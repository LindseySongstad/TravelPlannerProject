package com.songstadlindsey.travelplanner.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
// user data transfer object
@Data
public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Please enter email address")
    @Email
    private String email;
    @NotEmpty(message = "Please enter password")
    private String password;
}
