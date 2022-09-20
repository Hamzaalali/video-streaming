package com.example.uploadvideoapp.database;

import com.example.uploadvideoapp.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Long> {
}
