package com.example.demo.dto.videoDto;

import com.example.demo.entities.Video;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class VideoDTOConverter {

    @Autowired
    ModelMapper modelMapper;

    public VideoDTO convertirADto(Video video) {
        return modelMapper.map(video, VideoDTO.class);
    }

    public Video convertirAVideo(VideoDTO videoDTO) {
        return modelMapper.map(videoDTO, Video.class);
    }
}
