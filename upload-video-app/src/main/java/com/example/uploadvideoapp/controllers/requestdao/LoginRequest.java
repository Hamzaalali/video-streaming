package com.example.uploadvideoapp.controllers.requestdao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {
    String userName;
    String password;
}
