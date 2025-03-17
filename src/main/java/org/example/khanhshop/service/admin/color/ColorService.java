package org.example.khanhshop.service.admin.color;

import org.example.khanhshop.dto.admin.response.ColorResponse;
import org.example.khanhshop.entity.Color;
import org.example.khanhshop.repository.admin.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorService implements ColorItf {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<ColorResponse> getAll() {
        List<Color> colors=colorRepository.findAll();
        return colors.stream().map(c->mapToResponse(c)).collect(Collectors.toUnmodifiableList());
    }

    public ColorResponse mapToResponse(Color color){
        ColorResponse response=new ColorResponse();
        response.setColorName(color.getName());
        response.setId(color.getId());
        return response;
    }
}
