package com.stride.stride.dto;

import com.stride.stride.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String firstName;
    private String email;
    private LocalDateTime createdAt;
    private String timezone;

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.timezone = user.getTimeZone();
    }
}
