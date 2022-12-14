package com.example.fileservice.fileuploading;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.*;

@Service
@RequiredArgsConstructor
public class LocalStorageService implements IFileService {

    private String storageUrl="/storage/";
    @Override
    public String uploadPhoto(FileUploadRequest fileUploadRequest) throws IOException {
        String localUrl=storageUrl+fileUploadRequest.getFileName();
        File file = new File(localUrl);
        fileUploadRequest.getFile().transferTo(file);
        return "http://localhost:8081/api/file/photo/"+fileUploadRequest.getFileName();
    }
    @Override
    public String uploadVideo(FileUploadRequest fileUploadRequest) throws IOException {
        String localUrl=storageUrl+fileUploadRequest.getFileName();
        File file = new File(localUrl);
        fileUploadRequest.getFile().transferTo(file);
        return "http://localhost:8081/api/file/video/"+fileUploadRequest.getFileName();
    }

    public Mono<Resource> getVideo(String title) throws FileNotFoundException {
        File file =new File(storageUrl+title);
        InputStream stream = new FileInputStream(file);
        InputStreamResource inputStreamResource = new InputStreamResource(stream);

        return Mono.fromSupplier(()->inputStreamResource);
    }
    public InputStream getPhoto(String title) throws FileNotFoundException {
        File file =new File(storageUrl+title);
        InputStream stream = new FileInputStream(file);
        return stream;
    }
}
