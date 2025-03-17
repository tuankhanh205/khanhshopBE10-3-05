package org.example.khanhshop.service.admin.category;

import org.example.khanhshop.dto.admin.response.CategoryResponse;
import org.example.khanhshop.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryItf {
    Page<CategoryResponse> findAll(int page, int size);
}
