package com.limyel.service;

import com.limyel.models.UserModel;

public interface UserService {
    boolean createUser(UserModel userModel);
    UserModel retriveUserById(int id);
    boolean updateUserById(UserModel userModel, int id);
    boolean deleteUserById(int id);
}
