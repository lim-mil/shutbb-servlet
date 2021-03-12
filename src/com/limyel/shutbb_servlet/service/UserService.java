package com.limyel.shutbb_servlet.service;

import com.limyel.shutbb_servlet.models.UserModel;

public interface UserService {
    boolean createUser(UserModel userModel);
    UserModel retriveUserById(int id);
    boolean updateUserById(UserModel userModel, int id);
    boolean deleteUserById(int id);
}
