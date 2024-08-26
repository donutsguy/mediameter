package com.tsystem.mediameter.services;

import com.tsystem.mediameter.dtos.MediaDto;
import com.tsystem.mediameter.models.MediaModel;
import com.tsystem.mediameter.repositories.MediaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    public Page<MediaDto> getAll(Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<MediaModel> medias = mediaRepository.findAll(pageRequest);

        return medias.map(MediaDto::from);
    }
}
