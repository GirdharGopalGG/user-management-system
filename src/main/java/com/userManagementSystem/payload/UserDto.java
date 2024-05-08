package com.userManagementSystem.payload;


import lombok.Data;

@Data            //@DATA IS USED FOR PROVIDING GETTERS AND SETTERS

public class UserDto {
    private long id;
    private String name;
    private String username;
    private String emailId;
    private String password;
    private String userRole;

}
