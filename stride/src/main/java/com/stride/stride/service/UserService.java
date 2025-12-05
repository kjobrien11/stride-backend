package com.stride.stride.service;

import com.stride.stride.dto.UserDTO;
import com.stride.stride.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
