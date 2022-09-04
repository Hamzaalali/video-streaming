package com.example.authenticationservice.controller;

import com.example.authenticationservice.service.AuthenticationService;
import com.example.authenticationservice.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(path="/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
    boolean isValid = this.authenticationService.login(user);
        String value;
        String message;
        int statusCode;
        if(isValid){
            message="accessToken";
            value= this.authenticationService.getAccessToken(user.getUserName());
            statusCode=200;
        }else{
            message="error";
            value="invalid credentials";
            statusCode=401;
        }
        Map<String,String>returnObject=new HashMap<>();
        returnObject.put(message,value);
    return new ResponseEntity<>(returnObject, HttpStatus.valueOf(statusCode));
    }
    @PostMapping(path = "token")
    public ResponseEntity<Object>validateAccessToken(HttpServletRequest request){
        String accessToken=request.getHeader("Authentication");
        boolean isValid=this.authenticationService.isValidAccessToken(accessToken);
        if(isValid){
            return new ResponseEntity<>("valid access token",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("invalid access token",HttpStatus.UNAUTHORIZED);
    }
}
