package com.example.showvideoapp.database;

import com.example.showvideoapp.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Long> {
}
