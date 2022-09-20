package com.example.uploadvideoapp.request;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IRequest {
    String request(String url,Object requestObject) throws JsonProcessingException;
}
