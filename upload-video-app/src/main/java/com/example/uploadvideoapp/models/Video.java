package com.example.uploadvideoapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private String videoCoverUrl;
    private String name;
}
