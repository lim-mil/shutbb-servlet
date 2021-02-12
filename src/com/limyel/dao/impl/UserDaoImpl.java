package com.limyel.dao.impl;

import com.limyel.dao.UserDao;
import com.limyel.models.UserModel;

public class UserDaoImpl implements UserDao {
    @Override
    public int createUser(UserModel userModel) {
        int timestamp = (int) System.currentTimeMillis();
        String sql = "insert into user_model (created, updated, username, password, signature, status, email) " +
                "values (?, ?, ?, ?, ?, ?, ?);";

        return 0;
    }

    @Override
    public UserModel retriveUserById(int id) {
        return null;
    }

    @Override
    public int updateUser(UserModel userModel) {
        return 0;
    }

    @Override
    public int deleteUserById(int id) {
        return 0;
    }
}
