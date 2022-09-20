package com.example.fileservice.fileuploading;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/file")
@RequiredArgsConstructor
public class FileServiceController {

    private final AWSS3Service awsS3Service;
    @PostMapping(path = "upload")
    public ResponseEntity<Object> fileUpload(HttpServletRequest request,@ModelAttribute()FileUploadRequest fileUploadRequest) throws IOException, ServletException {
        String url= awsS3Service.uploadFile(fileUploadRequest);
        Map<String,String > urlMap=new HashMap<>();
        urlMap.put("url",url);
        return new ResponseEntity<>(urlMap, HttpStatus.ACCEPTED);
    }
}
