package com.example.uploadvideoapp.services;

import com.example.uploadvideoapp.database.VideoDAO;
import com.example.uploadvideoapp.request.PostRequest;
import com.example.uploadvideoapp.models.Video;
import com.example.uploadvideoapp.database.VideoRepo;
import com.example.uploadvideoapp.controllers.requestdao.VideoUploadRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoUploadService {
    private final VideoDAO videoDAO;
    private final PostRequest postRequest;
    public void uploadVideo(VideoUploadRequest videoUploadRequest)  {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            String videoUploadResponse=uploadFile(videoUploadRequest.getVideo());
            String videoCoverUploadResponse=uploadFile(videoUploadRequest.getVideoCover());
            JsonNode videoUploadResponseTree=objectMapper.readTree(videoUploadResponse);
            JsonNode videoCoverUploadResponseTree=objectMapper.readTree(videoCoverUploadResponse);
            String url= videoUploadResponseTree.get("url").asText();
            String videoCoverUrl=videoCoverUploadResponseTree.get("url").asText();
            Video video=new Video();
            video.setName(videoUploadRequest.getName());
            video.setUrl(url);
            video.setVideoCoverUrl(videoCoverUrl);
            videoDAO.save(video);
        }catch (Exception e){
        }
    }
    private String uploadFile(MultipartFile file) throws JsonProcessingException {
        String requestUrl="http://localhost:8081/api/file/upload";
        MultiValueMap<String,Object > body=new LinkedMultiValueMap<>();
        body.add( "video",file.getResource());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);
        String response=postRequest.request(requestUrl,requestEntity);
        return response;
    }
}
