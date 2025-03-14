package org.example.khanhshop.repository;

import org.example.khanhshop.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
}
