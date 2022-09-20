package com.example.showvideoapp.controllers;

import com.example.showvideoapp.models.Video;
import com.example.showvideoapp.services.ShowVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/video")
@RequiredArgsConstructor
public class ShowVideoController {
    private final ShowVideoService showVideoService;
    @GetMapping()
    public void getVideoList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        List<Video> videos=showVideoService.getVideoList();
        request.setAttribute("videos",videos);
        request.getRequestDispatcher("/WEB-INF/views/videos.jsp").forward(request, response);
    }

    @GetMapping(path = "/{id}")
    public void getVideo(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Long id) throws ServletException, IOException {
        Video video=showVideoService.getVideo(id);
        request.setAttribute("video",video);
        request.getRequestDispatcher("/WEB-INF/views/video.jsp").forward(request, response);
    }

}
