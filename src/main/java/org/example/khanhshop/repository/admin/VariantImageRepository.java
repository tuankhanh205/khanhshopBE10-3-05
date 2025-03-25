package org.example.khanhshop.repository.admin;

import org.example.khanhshop.entity.VariantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantImageRepository extends JpaRepository<VariantImage, Long> {
}
