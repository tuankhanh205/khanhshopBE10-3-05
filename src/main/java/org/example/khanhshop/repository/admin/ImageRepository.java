package org.example.khanhshop.repository.admin;

import jakarta.transaction.Transactional;
import org.example.khanhshop.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Images i WHERE i.product.id = :productId")
    void deleteByProductId(@Param("productId") Long productId);
}
