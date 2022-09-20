package com.example.showvideoapp.services;

import com.example.showvideoapp.controllers.requestdao.AuthRequest;
import com.example.showvideoapp.controllers.requestdao.LoginRequest;
import com.example.showvideoapp.request.PostRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final PostRequest postRequest;
    public boolean isAuthenticated(AuthRequest authRequest){
        boolean isValid;
        try{
            String url = "http://localhost:8080/api/auth/validate-token";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper objectMapper = new ObjectMapper();
            HttpEntity<String> accessRequest=new HttpEntity<>(objectMapper.writeValueAsString(authRequest),headers);
            String requestResponse= postRequest.request(url,accessRequest);
            JsonNode responseTree=objectMapper.readTree(requestResponse);
            isValid= responseTree.get("isValid").asBoolean();
        }catch (Exception e){
            isValid=false;
        }
        return isValid;
    }
    public boolean login(HttpServletResponse response, LoginRequest loginData) {
        boolean isValid;

        try{
            String url = "http://localhost:8080/api/auth/login";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper objectMapper = new ObjectMapper();
            HttpEntity<String> loginRequest=new HttpEntity<>(objectMapper.writeValueAsString(loginData),headers);
            String requestResponse= postRequest.request(url,loginRequest);
            JsonNode responseTree=objectMapper.readTree(requestResponse);
            isValid= responseTree.get("isValid").asBoolean();
            String accessToken=responseTree.get("accessToken").asText();
            if(isValid){
                Cookie cookie = new Cookie(AUTHORIZATION, accessToken);
                cookie.setMaxAge(60*10);
                cookie.setSecure(false);
                cookie.setHttpOnly(true);
                cookie.setPath("/api");
                response.addCookie(cookie);;
            }
        }catch (Exception e){
            isValid=false;
        }
        return isValid;
    }
    public void loginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }
}
