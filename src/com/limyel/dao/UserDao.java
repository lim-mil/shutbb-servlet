package com.limyel.dao;

import com.limyel.models.UserModel;

public interface UserDao {
    boolean createUser(UserModel userModel);
    UserModel retriveUserById(int id);
    boolean updateUserById(UserModel userModel, int id);
    boolean deleteUserById(int id);
    UserModel retriveUserByUsername(String username);
}
