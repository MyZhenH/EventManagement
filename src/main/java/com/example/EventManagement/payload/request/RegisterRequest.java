package com.example.EventManagement.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Förnamn är obligatoriskt")
    private String firstName;

    @NotBlank(message = "Efternamn är obligatoriskt")
    private String lastName;

    @NotBlank(message = "Email är obligatoriskt")
    @Email(message = "Ogiltig email-format")
    private String email;

    @NotBlank(message = "Lösenord är obligatoriskt")
    @Size(min = 8, message = "Lösenordet måste vara minst 8 tecken")
    private String password;

    public RegisterRequest(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}