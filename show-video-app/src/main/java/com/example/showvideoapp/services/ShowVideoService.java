package com.example.showvideoapp.services;

import com.example.showvideoapp.database.VideoDAO;
import com.example.showvideoapp.models.Video;
import com.example.showvideoapp.request.PostRequest;
import com.example.showvideoapp.database.VideoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowVideoService {
    private final VideoDAO videoDAO;
    private final PostRequest postRequest;
    public List<Video> getVideoList(){
        return videoDAO.getAllVideos();
    }
    public Video getVideo(Long id){
        return videoDAO.getVideo(id);
    }
}
