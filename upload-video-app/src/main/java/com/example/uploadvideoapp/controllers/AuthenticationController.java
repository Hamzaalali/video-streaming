package com.example.uploadvideoapp.controllers;

import com.example.uploadvideoapp.services.AuthService;
import com.example.uploadvideoapp.controllers.requestdao.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthService authService;
    @GetMapping("ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("UP", HttpStatus.ACCEPTED);
    }
    @PostMapping("login")
    public void login(HttpServletRequest request, HttpServletResponse response,@ModelAttribute LoginRequest loginRequest)  {
        boolean isValid=authService.login(response,loginRequest);
        try{
            if(isValid)
                request.getRequestDispatcher("/WEB-INF/views/uploadFile.jsp").forward(request, response);
            else
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }catch (Exception e){

        }
    }
}
