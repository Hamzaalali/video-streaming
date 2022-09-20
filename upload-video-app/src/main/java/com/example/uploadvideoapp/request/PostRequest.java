package com.example.uploadvideoapp.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostRequest implements IRequest {

    @Override
    public String request(String url, Object requestObject) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response =restTemplate.postForObject(url, requestObject,String.class);
        return response;
    }
}
