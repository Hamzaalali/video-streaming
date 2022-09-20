package com.example.uploadvideoapp.database;

import com.example.uploadvideoapp.models.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MysqlVideoDAO implements VideoDAO{
    private final VideoRepo videoRepo;
    @Override
    public List<Video> getAllVideos() {
        return  videoRepo.findAll();
    }

    @Override
    public Video getVideo(Long id) {
        return videoRepo.getReferenceById(id);
    }

    @Override
    public Video save(Video video){
       return videoRepo.save(video);
    }
}
