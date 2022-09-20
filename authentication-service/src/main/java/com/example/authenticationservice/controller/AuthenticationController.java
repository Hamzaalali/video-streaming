package com.example.authenticationservice.controller;

import com.example.authenticationservice.service.AuthenticationService;
import com.example.authenticationservice.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.example.authenticationservice.controller.*;

@RestController
@RequestMapping(path = "/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("validate-token")
    public ResponseEntity<Object> validateRequest(HttpServletRequest request, HttpServletResponse response,@RequestBody AuthRequest authRequest) throws ServletException, IOException {
        boolean isValid=this.authenticationService.isValidAccessToken(authRequest.getAccessToken());
        Map<String ,Boolean> responseMap=new HashMap<>();
        responseMap.put("isValid",isValid);
        return new ResponseEntity<>(responseMap,HttpStatus.ACCEPTED);
    }
    @PostMapping(path="/login")
    public ResponseEntity<Object> login( @RequestBody User user) {
        boolean isValid = this.authenticationService.login(user);
        Map<String ,Object> responseMap=new HashMap<>();
        if(isValid){
            String accessToken= authenticationService.getAccessToken(user.getUserName());
            responseMap.put("accessToken",accessToken);
        }
        responseMap.put("isValid",isValid);
        return new ResponseEntity<>(responseMap,HttpStatus.ACCEPTED);
    }
}
