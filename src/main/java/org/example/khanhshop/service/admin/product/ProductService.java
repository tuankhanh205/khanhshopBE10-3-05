package org.example.khanhshop.service.admin.product;

import org.example.khanhshop.dto.request.ProductDetailRequest;
import org.example.khanhshop.dto.request.ProductRequest;
import org.example.khanhshop.dto.response.ProductDetailResponse;
import org.example.khanhshop.dto.response.ProductResponse;
import org.example.khanhshop.entity.*;
import org.example.khanhshop.repository.*;
import org.example.khanhshop.service.uploadfile.impl.UploadFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductItf{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ImageRepository imageRepository;
@Autowired
private UploadFileImpl uploadFile;

    @Override
    public ProductResponse save(ProductRequest productRequest,List<MultipartFile> file) throws IOException {
           Product product= createProduct(productRequest);

            uploadImage(file,product);
            createProductDetail(productRequest,product);
            createBrand(productRequest,product);
            Product save=productRepository.save(product);
        return mapToResponse(save);
    }

    @Override
    public Page<ProductResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.map(this::mapToResponse);
    }


    public ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());
        response.setCategoryName(product.getCategory().getName());
        response.setBrandName(product.getBrand().getName());
        Long totalStock=productDetailRepository.getTotalStockByProductId(response.getId());
        response.setStock(totalStock);
        List<String> images=new ArrayList<>();
        for (Images images1:product.getImages()){
            images.add(images1.getImage());
        }
        response.setImages(images);

        List<ProductDetailResponse> detailResponses = new ArrayList<>();

        for (ProductDetail detail : product.getProductDetails()) {
            ProductDetailResponse detailResponse = new ProductDetailResponse();
            detailResponse.setId(detail.getId());
            detailResponse.setPrice(detail.getPrice());
            detailResponse.setStock(detail.getStock());
            detailResponse.setColorName(detail.getColor().getName());
            detailResponse.setSizeName(detail.getSize().getName());
            detailResponses.add(detailResponse);
        }
        response.setProductDetails(detailResponses);
        return response;
    }

    public void createBrand(ProductRequest productRequest,Product product){
        Brand brand=brandRepository.findById(productRequest.getBrandId()).orElseThrow();
        product.setBrand(brand);
    }


    public void uploadImage(List<MultipartFile> file,Product product) throws IOException {
       if(file==null||file.isEmpty()){
           throw new RuntimeException("file is empty");
       }
       List<Images> images=new ArrayList<>();
       for (MultipartFile images1:file){
            String imageUrl= uploadFile.uploadImage(images1);
           System.out.println(imageUrl);
            Images images2=new Images();
            images2.setImage(imageUrl);
            images2.setProduct(product);
            images.add(images2);
       }
       imageRepository.saveAll(images);

       product.setImages(images);
    }

    public void createProductDetail(ProductRequest productRequest,Product product) {
        List<ProductDetail> productDetails = new ArrayList<>();
        for (ProductDetailRequest productDetailRequest : productRequest.getProductDetails()) {
            ProductDetail  productDetail = new ProductDetail();
            Color color = colorRepository.findById(productDetailRequest.getColorId()).orElseThrow(() -> new RuntimeException("ko co id color nay"));
            Size size = sizeRepository.findById(productDetailRequest.getSizeId()).orElseThrow(() -> new RuntimeException("ko co id size nay"));
            productDetail.setSize(size);
            productDetail.setColor(color);
            productDetail.setPrice(productDetailRequest.getPrice());
            productDetail.setStock(productDetailRequest.getStock());
            productDetail.setProduct(product);
            productDetails.add(productDetail);
        }
        productDetailRepository.saveAll(productDetails);
        product.setProductDetails(productDetails);
    }
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        Category category = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("ko co id nay"));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setCategory(category);
         product=productRepository.save(product);
       return product ;

    }
}
