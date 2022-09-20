package com.example.showvideoapp.database;

import com.example.showvideoapp.models.Video;

import java.util.List;

public interface VideoDAO {
    public List<Video> getAllVideos();
    public Video getVideo(Long id);
}
