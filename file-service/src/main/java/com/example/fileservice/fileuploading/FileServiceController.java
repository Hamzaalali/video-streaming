package com.example.fileservice.fileuploading;

import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/file")
@RequiredArgsConstructor
public class FileServiceController {

    private final IFileService iFileService;

    @GetMapping(value = "/video/{title}")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) throws FileNotFoundException {
        return iFileService.getVideo(title);
    }
    @GetMapping(value = "/photo/{title}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable String title) throws IOException {
        InputStream photoStream=iFileService.getPhoto(title);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(IOUtils.toByteArray(photoStream), headers, HttpStatus.CREATED);
    }


    @PostMapping(path = "upload/video")
    public ResponseEntity<Object> uploadVideo(HttpServletRequest request,@ModelAttribute()FileUploadRequest fileUploadRequest) throws IOException, ServletException {
        String url= iFileService.uploadVideo(fileUploadRequest);
        Map<String,String > urlMap=new HashMap<>();
        urlMap.put("url",url);
        return new ResponseEntity<>(urlMap, HttpStatus.ACCEPTED);
    }
    @PostMapping(path = "upload/photo")
    public ResponseEntity<Object> uploadPhoto(HttpServletRequest request,@ModelAttribute()FileUploadRequest fileUploadRequest) throws IOException, ServletException {
        String url= iFileService.uploadPhoto(fileUploadRequest);
        Map<String,String > urlMap=new HashMap<>();
        urlMap.put("url",url);
        return new ResponseEntity<>(urlMap, HttpStatus.ACCEPTED);
    }
}
