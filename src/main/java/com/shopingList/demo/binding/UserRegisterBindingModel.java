package com.shopingList.demo.binding;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size (min = 3, max = 20, message = "username must be min-3 and max-20 characters")
    @NotBlank (message = "please enter username")
    private String username;
    @Email(message = "please enter valid email")
    private String email;
    @Size (min = 3, max = 20, message = "password must be min 3 and max 20 characters")
    @NotBlank (message = "please enter password")
    private String password;
    @Size (min = 3, max = 20, message = "password must be min 3 and max 20 characters")
    @NotBlank (message = "please enter password")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
