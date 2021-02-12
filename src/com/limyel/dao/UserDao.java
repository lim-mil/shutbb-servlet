package com.limyel.dao;

import com.limyel.models.UserModel;

public interface UserDao {
    int createUser(UserModel userModel);
    UserModel retriveUserById(int id);
    int updateUser(UserModel userModel);
    int deleteUserById(int id);
}
