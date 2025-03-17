package org.example.khanhshop.service.admin.category;

import org.example.khanhshop.dto.admin.response.CategoryResponse;
import org.example.khanhshop.entity.Category;
import org.example.khanhshop.repository.admin.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CategoryItf{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<CategoryResponse> findAll(int page, int size) {
       Pageable pageable= PageRequest.of(page, size);
       Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(n->mapToResponse(n));

    }
    public CategoryResponse mapToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        return categoryResponse;
    }
}
