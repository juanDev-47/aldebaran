package com.example.aldebaran.service.dto;

import lombok.Data;

@Data
public class SaveUserDTO {
    private String username;
    private String password;
    private String email;
    private boolean locked;
    private boolean disabled;
}
