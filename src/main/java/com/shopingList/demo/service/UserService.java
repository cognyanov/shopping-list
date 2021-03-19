package com.shopingList.demo.service;

import com.shopingList.demo.model.entity.UserEntity;
import com.shopingList.demo.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);


    UserServiceModel findByUsernameAndPassword(String username, String password);
}
