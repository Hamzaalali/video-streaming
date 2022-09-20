package com.example.showvideoapp.request;

import com.fasterxml.jackson.core.JsonProcessingException;
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
