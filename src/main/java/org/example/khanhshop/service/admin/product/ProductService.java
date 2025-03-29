package org.example.khanhshop.service.admin.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.khanhshop.dto.admin.request.ProductRequest;
import org.example.khanhshop.dto.admin.request.VariantAttributeRequest;
import org.example.khanhshop.dto.admin.request.VariantRequest;
import org.example.khanhshop.dto.admin.response.ProductResponse;
import org.example.khanhshop.dto.admin.response.VariantResponse;
import org.example.khanhshop.entity.*;
import org.example.khanhshop.repository.admin.*;
import org.example.khanhshop.service.uploadfile.impl.UploadFileImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductService implements ProductItf {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeValueRepository attributeValueRepository;
    private final VariantAttributeRepository variantAttributeRepository;
    private final VariantRepository variantRepository;
    private final UploadFileImpl uploadFile;
    private final ProductImageRepository productImageRepository;
    private final VariantImageRepository variantImageRepository;


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product -> mapToResponse(product)).collect(Collectors.toUnmodifiableList());
    }


    @Override
    public ProductResponse save(ProductRequest productRequest, List<MultipartFile> productFiles, MultipartFile variantImage) throws IOException {
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseGet(null);
        if(category==null){
            Category category1=new Category();
            category.setName(productRequest.getCategoryName());
            categoryRepository.save(category1);
            if(category1.getName().equalsIgnoreCase(category.getName())){
                throw  new IOException("ten trung nhap lai");
            }
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setBasePrice(productRequest.getBasePrice());
        product.setDescription(productRequest.getDescription());
        product.setCategory(category);
        product = productRepository.save(product); // 🔹 Lưu để có ID

        List<ProductImage> productImages = uploadImageAll(product, productFiles);



        List<Variant> variants = createVariant(product, productRequest);



        if (!productImages.isEmpty()) {
            String firstImage = productImages.get(0).getImageUrl();
            for (Variant variant : variants) {
                if (variantImage != null && !variantImage.isEmpty()) {
                    uploadImageVariant(variant, variantImage);
                } else if (variant.getVariantImage() == null) {
                    VariantImage variantImg = new VariantImage();
                    variantImg.setImageUrl(firstImage);
                    variantImg.setVariant(variant);
                    variant.setVariantImage(variantImg);
                    variantImageRepository.save(variantImg);
                    variantRepository.save(variant);
                }
            }
        }


        product = productRepository.save(product);


        Product savedProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));
        savedProduct.getVariants().size();
        savedProduct.getProductImages().size();

        return mapToResponse(savedProduct);
    }


    public List<Variant> createVariant(Product product, ProductRequest productRequest) {
        Map<Long, List<AttributeValue>> attributeOptions = new HashMap<>();
        List<Variant> variantList = new ArrayList<>();

        for (VariantRequest variantRequest : productRequest.getVariantRequests()) {
            for (VariantAttributeRequest variantAttributeRequest : variantRequest.getVariantAttributeRequests()) {
                Attribute attribute = attributeRepository.findById(variantAttributeRequest.getAttributeId())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy thuộc tính với ID: " + variantAttributeRequest.getAttributeId()));

                List<AttributeValue> attributeValues=new ArrayList<>();

                if(variantAttributeRequest.getAttributeValueIds()!=null&&!variantAttributeRequest.getAttributeValueIds().isEmpty()){
                    attributeValues = attributeValueRepository.findAllById(variantAttributeRequest.getAttributeValueIds());
                }
                if(attributeValues.isEmpty() && variantAttributeRequest.getNewAttributeValueRequest() != null) {

                        for (String newValue : variantAttributeRequest.getNewAttributeValueRequest()) {

                            AttributeValue newAttributeValue = new AttributeValue();
                            newAttributeValue.setName(newValue);
                            newAttributeValue.setAttribute(attribute);
                            newAttributeValue = attributeValueRepository.save(newAttributeValue);
                            attributeValues.add(newAttributeValue);

                    }
                }
                attributeOptions.put(attribute.getId(), attributeValues);
            }
        }

        List<List<AttributeValue>> combinations = generateCombinations(new ArrayList<>(attributeOptions.values()));

        VariantRequest variantReq = !productRequest.getVariantRequests().isEmpty()
                ? productRequest.getVariantRequests().get(0)
                : new VariantRequest();

        for (List<AttributeValue> combination : combinations) {
            Variant variant = new Variant();
            variant.setProduct(product);
            variant.setSku(genSku(combination));
            variant.setPrice(Optional.ofNullable(variantReq.getPrice()).orElse(product.getBasePrice()));
            variant.setStock(Optional.ofNullable(variantReq.getStock()).orElse(0));
            variant = variantRepository.save(variant);
            variantList.add(variant);
            product.setVariants(variantList);

            for (AttributeValue value : combination) {
                VariantAttribute variantAttribute = new VariantAttribute();
                variantAttribute.setVariant(variant);
                variantAttribute.setAttribute(value.getAttribute());
                variantAttribute.setAttributeValue(value);
                variantAttributeRepository.save(variantAttribute);
            }

        }


        return variantList;
    }

    private String genSku(List<AttributeValue> attributeValues) {
        return attributeValues.stream()
                .map(attr -> attr.getName().toUpperCase())
                .reduce((a, b) -> a + "-" + b)
                .orElse("");
    }

    private List<List<AttributeValue>> generateCombinations(List<List<AttributeValue>> attributeGroups) {
        List<List<AttributeValue>> result = new ArrayList<>();
        generateCombinationsHelper(attributeGroups, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateCombinationsHelper(List<List<AttributeValue>> attributeGroups, int index, List<AttributeValue> current, List<List<AttributeValue>> result) {
        if (index == attributeGroups.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (AttributeValue value : attributeGroups.get(index)) {
            current.add(value);
            generateCombinationsHelper(attributeGroups, index + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public List<ProductImage> uploadImageAll(Product product, List<MultipartFile> multipartFiles) throws IOException {
        List<ProductImage> productImages = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            String imageUrl = uploadFile.uploadImage(multipartFile);
            ProductImage productImage = new ProductImage();
            productImage.setImageUrl(imageUrl);
            productImage.setProduct(product);
            productImages.add(productImage);
        }
        product.setProductImages(productImages);
        productImageRepository.saveAll(productImages);
        return productImages;
    }

    public void uploadImageVariant(Variant variant, MultipartFile variantFile) throws IOException {
        if (variantFile != null && !variantFile.isEmpty()) {
            String imageUrl = uploadFile.uploadImage(variantFile);
            VariantImage variantImage = new VariantImage();
            variantImage.setImageUrl(imageUrl);
            variantImage.setVariant(variant);
            variant.setVariantImage(variantImage);
            variantImageRepository.save(variantImage);
            variantRepository.save(variant);
        }
    }


    public ProductResponse mapToResponse(Product product) {

        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setCategory(product.getCategory().getName());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getBasePrice());
        productResponse.setDescription(product.getDescription());
        List<String> productImages = new ArrayList<>();

        for (ProductImage productImage : product.getProductImages()) {
            productImages.add(productImage.getImageUrl());
        }
        productResponse.setImageUrls(productImages);
        List<VariantResponse> variantResponses=new ArrayList<>();
        for (Variant variant : product.getVariants()) {
            VariantResponse variantResponse=new VariantResponse();
            variantResponse.setId(variant.getId());
            variantResponse.setSku(variant.getSku());
            variantResponse.setPrice(variant.getPrice());
            variantResponse.setStock(variant.getStock());
            variantResponses.add(variantResponse);
            variantResponse.setImage(variant.getVariantImage().getImageUrl());

        }
        productResponse.setVariants(variantResponses);
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());

        return productResponse;
    }
}
