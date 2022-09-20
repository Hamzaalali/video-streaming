package com.example.fileservice.fileuploading;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

    String uploadFile(FileUploadRequest fileUploadRequest);
}