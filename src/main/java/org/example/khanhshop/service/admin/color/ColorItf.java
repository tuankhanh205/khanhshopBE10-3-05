package org.example.khanhshop.service.admin.color;

import org.example.khanhshop.dto.admin.response.ColorResponse;
import org.example.khanhshop.repository.admin.ColorRepository;

import java.util.List;

public interface ColorItf {
    List<ColorResponse> getAll();
}
