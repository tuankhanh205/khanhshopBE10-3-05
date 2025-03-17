package org.example.khanhshop.service.admin.size;

import org.example.khanhshop.dto.admin.response.SizeResponse;
import org.example.khanhshop.entity.Size;
import org.example.khanhshop.repository.admin.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeService implements SizeItf{
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<SizeResponse> getAll() {
        List<Size> sizes = sizeRepository.findAll();
        return sizes.stream().map(s->mapToResponse(s)).collect(Collectors.toUnmodifiableList());
    }
    public SizeResponse mapToResponse(Size size) {
        SizeResponse sizeResponse=new SizeResponse();
        sizeResponse.setId(size.getId());
        sizeResponse.setSizeName(size.getName());
        return sizeResponse;
    }
}
