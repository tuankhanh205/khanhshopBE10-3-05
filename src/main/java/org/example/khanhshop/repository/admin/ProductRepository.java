package org.example.khanhshop.repository.admin;

import org.example.khanhshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select t from Product t where t.name like %:name%")
    Page<Product> findByName(@Param("name") String name, Pageable pageable);
}
