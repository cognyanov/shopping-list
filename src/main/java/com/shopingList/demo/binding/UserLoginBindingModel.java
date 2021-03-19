package com.shopingList.demo.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 3, max = 20, message = "username must be min-3 and max-20 characters")
    @NotBlank (message = "please enter username")
    private String username;

    @Size (min = 3, max = 20, message = "password must be min 3 and max 20 characters")
    @NotBlank (message = "please enter password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginBindingModel() {
    }
}
