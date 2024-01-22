package com.epicode.U5D2.controllers;

import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.exceptions.BadRequestException;
import com.epicode.U5D2.payload.users.NewUserDTO;
import com.epicode.U5D2.payload.users.NewUserResponseDTO;
import com.epicode.U5D2.payload.users.UserLoginDTO;
import com.epicode.U5D2.payload.users.UserLoginResponseDTO;
import com.epicode.U5D2.services.AuthService;
import com.epicode.U5D2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    UserServices userServices;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body) {
        String accessToken = authService.authenticateUser(body);
        return new UserLoginResponseDTO(accessToken);
    }

    @PostMapping("/register")
    public NewUserResponseDTO createUser(@RequestBody @Validated NewUserDTO newUserPayload, BindingResult validation) {
        System.out.println(validation);
        if(validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("There are errors in payload!");
        } else  {
            User newUser = userServices.save(newUserPayload);

            return new NewUserResponseDTO(newUser.getId());
        }
    }


}
