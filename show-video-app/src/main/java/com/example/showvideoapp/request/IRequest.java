package com.example.showvideoapp.request;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IRequest {
    String request(String url,Object requestObject) throws JsonProcessingException;
}
