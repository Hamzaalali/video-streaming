package com.example.fileservice.fileuploading;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface IFileService {

    String uploadVideo(FileUploadRequest fileUploadRequest) throws IOException;
    String uploadPhoto(FileUploadRequest fileUploadRequest) throws IOException;

    Mono<Resource> getVideo(String title) throws FileNotFoundException;

    InputStream getPhoto(String title) throws FileNotFoundException;
}