package com.example.showvideoapp.database;

import com.example.showvideoapp.models.Video;
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
}
