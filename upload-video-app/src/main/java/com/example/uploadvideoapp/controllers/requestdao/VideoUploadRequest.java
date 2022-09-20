package com.example.uploadvideoapp.controllers.requestdao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoUploadRequest implements Serializable {
    private MultipartFile video;
    private MultipartFile videoCover;
    private String name;
}
