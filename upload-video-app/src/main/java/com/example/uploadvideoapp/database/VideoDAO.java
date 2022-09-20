package com.example.uploadvideoapp.database;


import com.example.uploadvideoapp.models.Video;

import java.util.List;

public interface VideoDAO {
    public List<Video> getAllVideos();
    public Video getVideo(Long id);

    public Video save(Video video);
}
