package com.example.authenticationservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.authenticationservice.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    public boolean login(User user){
        return Objects.equals(user.getUserName(), "root") && Objects.equals(user.getPassword(), "root");
    }
    public String getAccessToken(String username){
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        return JWT.create()
            .withSubject(username)
            .withExpiresAt(new Date(System.currentTimeMillis() + 10000 * 60 * 1000))
            .sign(algorithm);
    }

    public boolean isValidAccessToken(String accessToken){
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        try{
            verifier.verify(accessToken);
        }catch (Exception exception){
            return false;
        }
        return true;
    }
}
