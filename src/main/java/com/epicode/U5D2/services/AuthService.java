package com.epicode.U5D2.services;

import com.epicode.U5D2.entities.Role;
import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.exceptions.BadRequestException;
import com.epicode.U5D2.exceptions.UnauthorizedException;
import com.epicode.U5D2.payload.users.NewUserDTO;
import com.epicode.U5D2.payload.users.UserLoginDTO;
import com.epicode.U5D2.repositories.UserDAO;
import com.epicode.U5D2.security.JWTTools;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body) {
        User user = userServices.findByEmail(body.email());

        if(bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Not valid credentials!");
        }
    }

    public User save(NewUserDTO body) {
        userDAO.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("Email " + user.getEmail() + " is already used");
        });
        User newUser = new User();
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        newUser.setSurname(body.surname());
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setRole(Role.USER);
        return userDAO.save(newUser);
    }
}

