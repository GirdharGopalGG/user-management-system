package com.userManagementSystem.service;

import com.userManagementSystem.payload.LoginDto;
import com.userManagementSystem.payload.UserDto;

public interface UserService {
    public UserDto addUser(UserDto userDto);

    String verifyLogin(LoginDto loginDto);
}
