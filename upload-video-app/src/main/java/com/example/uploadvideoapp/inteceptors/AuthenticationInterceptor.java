package com.example.uploadvideoapp.inteceptors;

import com.example.uploadvideoapp.services.AuthService;
import com.example.uploadvideoapp.controllers.requestdao.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Objects;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final AuthService authService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(Objects.equals(makeUrl(request), "auth/login")||Objects.equals(makeUrl(request), "auth/ping"))return true;
        AuthRequest authRequest = new AuthRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(AUTHORIZATION)) {
                    authRequest.setAccessToken(cookie.getValue());
                }
            }
        }
        if(!authService.isAuthenticated(authRequest)){
            authService.loginPage(request,response);
            return false;
        }
        return true;
    }
    String makeUrl(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        url= url.substring(url.indexOf("api/")+4);
        return url;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
