package com.epicode.U5D2.services;

import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.payload.users.NewUserDTO;
import com.epicode.U5D2.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserDAO userDAO;

    public Page<User> getUsers(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return userDAO.findAll(pageable);
    }

    public User save(NewUserDTO body) {
        userDAO.findByEmail(body.email()).ifPresent(user -> {
//            throw new RuntimeException()
        });
            return new User();
    }
}
