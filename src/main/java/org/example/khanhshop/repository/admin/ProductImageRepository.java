package org.example.khanhshop.repository.admin;

import org.example.khanhshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
}
