package com.epicode.U5D2.services;

import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.exceptions.UnauthorizedException;
import com.epicode.U5D2.payload.users.UserLoginDTO;
import com.epicode.U5D2.security.JWTTools;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserServices userServices;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body) {
        User user = userServices.findByEmail(body.email());

        if(body.password().equals(user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Not valid credentials!");
        }
    }
}

