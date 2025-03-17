package org.example.khanhshop.service.admin.brand;

import org.example.khanhshop.dto.admin.response.BrandResponse;
import org.example.khanhshop.entity.Brand;
import org.example.khanhshop.repository.admin.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService implements BranItf{
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<BrandResponse> getAll() {
        List<Brand> brands=brandRepository.findAll();
        return brands.stream().map(c->mapToResponse(c)).collect(Collectors.toUnmodifiableList());
    }
    public BrandResponse mapToResponse(Brand brand) {
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(brand.getId());
        brandResponse.setBrandName(brand.getName());
        return brandResponse;
    }
}
