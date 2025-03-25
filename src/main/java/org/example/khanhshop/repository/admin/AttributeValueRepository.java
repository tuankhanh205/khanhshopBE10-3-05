package org.example.khanhshop.repository.admin;

import org.example.khanhshop.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
    @Query("SELECT av FROM AttributeValue av WHERE av.name = :name AND av.attribute.id = :attributeId")
    Optional<AttributeValue> findByNameAndAttributeId(@Param("name") String name, @Param("attributeId") Long attributeId);
}
