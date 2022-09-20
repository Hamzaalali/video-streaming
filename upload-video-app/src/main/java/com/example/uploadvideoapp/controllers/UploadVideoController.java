package com.example.uploadvideoapp.controllers;

import com.example.uploadvideoapp.controllers.requestdao.VideoUploadRequest;
import com.example.uploadvideoapp.services.VideoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/video")
@RequiredArgsConstructor
public class UploadVideoController {

    private final VideoUploadService videoUploadService;
    @GetMapping("upload")
    public void videoUploadView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/uploadFile.jsp").forward(request, response);
    }
    @PostMapping(path = "upload")
    public void videoUpload(HttpServletRequest request, HttpServletResponse response, @ModelAttribute() VideoUploadRequest videoUploadRequest) throws IOException, ServletException {
        videoUploadService.uploadVideo(videoUploadRequest);
        request.getRequestDispatcher("/WEB-INF/views/uploadFile.jsp").forward(request, response);

    }
}
