package com.example.showvideoapp.controllers;

import com.example.showvideoapp.services.AuthService;
import com.example.showvideoapp.controllers.requestdao.LoginRequest;
import com.example.showvideoapp.services.ShowVideoService;
import com.example.showvideoapp.models.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthService authService;
    private final ShowVideoService showVideoService;
    @GetMapping("ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("UP", HttpStatus.ACCEPTED);
    }
    @PostMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response,@ModelAttribute LoginRequest loginRequest)  {
        boolean isValid=authService.login(response,loginRequest);
        try{
            if(isValid){
                List<Video> videos=showVideoService.getVideoList();
                request.setAttribute("videos",videos);
                request.getRequestDispatcher("/WEB-INF/views/videos.jsp").forward(request, response);
            }
            else
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }catch (Exception e){

        }
    }
}
