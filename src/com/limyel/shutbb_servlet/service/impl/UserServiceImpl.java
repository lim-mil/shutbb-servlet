package com.limyel.shutbb_servlet.service.impl;

import com.limyel.shutbb_servlet.dao.UserDao;
import com.limyel.shutbb_servlet.dao.impl.UserDaoImpl;
import com.limyel.shutbb_servlet.models.UserModel;
import com.limyel.shutbb_servlet.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean createUser(UserModel userModel) {
        return userDao.createUser(userModel);
    }

    @Override
    public UserModel retriveUserById(int id) {
        return userDao.retriveUserById(id);
    }

    @Override
    public boolean updateUserById(UserModel userModel, int id) {
        return userDao.updateUserById(userModel, id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }
}
