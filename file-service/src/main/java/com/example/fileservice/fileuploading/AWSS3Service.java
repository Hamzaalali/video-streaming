package com.example.fileservice.fileuploading;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AWSS3Service implements IFileService {
    private final AmazonS3Client awsS3Client;
    @Override
    public String uploadFile(FileUploadRequest fileUploadRequest) {
        MultipartFile file=fileUploadRequest.getVideo();
        String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        String key = UUID.randomUUID().toString() + "." +filenameExtension;

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(file.getContentType());

        try {
            awsS3Client.putObject("hamzatube-bucket", key, file.getInputStream(), metaData);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occured while uploading the file");
        }

        awsS3Client.setObjectAcl("hamzatube-bucket", key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl("hamzatube-bucket", key);
    }


}