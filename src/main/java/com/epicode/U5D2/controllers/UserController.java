package com.epicode.U5D2.controllers;

import com.epicode.U5D2.entities.User;
import com.epicode.U5D2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String orderBy) {
        return userServices.getUsers(page, size, orderBy);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable UUID userId) {
        return userServices.findById(userId);
    }

    @PutMapping("/userId")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User getByIdAndUpdate(@PathVariable UUID userId, @RequestBody User modifyUserPayload) {
        return userServices.findByIdAndUpdate(userId, modifyUserPayload);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void getUserByIdAndDelete(@PathVariable UUID userId) {
        userServices.findByIdAndDelete(userId);
    }
}
