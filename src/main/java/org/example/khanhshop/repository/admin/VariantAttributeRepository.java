package org.example.khanhshop.repository.admin;

import org.example.khanhshop.entity.VariantAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributeRepository extends JpaRepository<VariantAttribute, Long> {
}
