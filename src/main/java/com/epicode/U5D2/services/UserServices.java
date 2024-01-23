package com.epicode.U5D2.services;

import com.epicode.U5D2.entities.Role;
import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.exceptions.BadRequestException;
import com.epicode.U5D2.exceptions.NotFoundException;
import com.epicode.U5D2.payload.users.NewUserDTO;
import com.epicode.U5D2.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
            throw new BadRequestException("Email " + user.getEmail() + " is already used");
        });
        User newUser = new User();
        newUser.setEmail(body.email());
        newUser.setName(body.name());
        newUser.setSurname(body.surname());
        newUser.setPassword(body.password());
        newUser.setRole(Role.USER);
        return userDAO.save(newUser);
    }

    public User findById(UUID id) {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        User found = this.findById(id);
        userDAO.delete(found);
    }

    public User findByIdAndUpdate(UUID id, User body) {
        User found = this.findById(id);
        found.setPassword(body.getPassword());
        found.setRole(body.getRole());
        found.setEmail(body.getEmail());
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        return userDAO.save(found);
    }

    public User findByEmail(String email) throws NotFoundException {
        return userDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("User with email " + email + " not found!"));
    }
}
