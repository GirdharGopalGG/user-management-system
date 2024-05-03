package com.userManagementSystem.service;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.payload.LoginDto;
import com.userManagementSystem.payload.UserDto;
import com.userManagementSystem.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{

    private JWTService jwtService;
    private AppUserRepository userRepository;

    public UserServiceImpl(JWTService jwtService, AppUserRepository userRepository){
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        //A REPOSITORY LAYER CANNOT SAVE DTO CONTENT TO DATABASE
        // SO CONVERTING DTO TO ENTITY
        AppUser user = mapToEntity(userDto);
        AppUser savedUser = userRepository.save(user);

        //CONVERTING ENTITY BACK TO DTO TO MATCH WITH RETURN TYPE

        UserDto dto = mapToDto(savedUser);
        return dto;

    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<AppUser> opUser = userRepository.findByUsername(loginDto.getUsername());
        if(opUser.isPresent())
        {
            AppUser user = opUser.get();
            if( BCrypt.checkpw(loginDto.getPassword(),user.getPassword()))
               return  jwtService.generateToken(user);
        }
        return null;
    }

    UserDto mapToDto(AppUser user){

    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setEmailId(user.getEmailId());
    dto.setUsername(user.getUsername());
    dto.setName(user.getName());
    return dto;
}


AppUser mapToEntity(UserDto dto){
    AppUser user = new AppUser();
    user.setName(dto.getName());
    user.setUsername(dto.getUsername());
    user.setEmailId(dto.getEmailId());
    user.setPassword(BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt(10)) );
    return user;
}


}


