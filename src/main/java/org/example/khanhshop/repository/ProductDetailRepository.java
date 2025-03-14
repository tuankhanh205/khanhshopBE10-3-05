package org.example.khanhshop.repository;

import org.example.khanhshop.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    @Query("SELECT COALESCE(SUM(pd.stock), 0) FROM ProductDetail pd WHERE pd.product.id = :productId")
    Long getTotalStockByProductId(@Param("productId") Long productId);

}
