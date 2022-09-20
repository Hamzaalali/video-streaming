package com.example.showvideoapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Entity
@Table(name="video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private String videoCoverUrl;
    private String name;
}
