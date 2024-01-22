package com.epicode.U5D2.payload.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Name is required!")
        @Size(min = 3, max = 30, message = "Name must contains between 3 and 30 characters!")
        String name,
        @NotEmpty(message = "Surname is required!")
        @Size(min = 3, max = 30, message = "Surname must contains between 3 and 30 characters!")
        String surname,
        @Email(message = "Inserted email does not valid!")
        @NotEmpty(message = "Email is required!")
        String email,
        @NotEmpty(message = "Password is required!")
        @Size(min = 4, message = "Password must contain at least 4 characters!")
        String password) {
}
