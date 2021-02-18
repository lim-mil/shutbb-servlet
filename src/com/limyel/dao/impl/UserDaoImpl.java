package com.limyel.dao.impl;

import com.limyel.dao.UserDao;
import com.limyel.models.UserModel;
import com.limyel.utils.DBUtil;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean createUser(UserModel userModel) {
        int timestamp = (int) System.currentTimeMillis();
        String sql = "insert into user_model (created, updated, username, password, signature, status, email) " +
                "values (?, ?, ?, ?, ?, ?, ?);";
        List<Object> params = new LinkedList<>();
        params.add(timestamp);
        params.add(timestamp);
        params.add(userModel.getUsername());
        params.add(userModel.getPassword());
        params.add(userModel.getSignature());
        params.add(userModel.getStatus());
        params.add(userModel.getEmail());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public UserModel retriveUserById(int id) {
        String sql = "selelct * from user_model where id=?";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            Map<String, Object> result = DBUtil.getInstance().queryByPreparedStatement(sql, params);
            UserModel user = new UserModel();
            user.setEmail((String) result.get("email"));
            user.setStatus((int) result.get("status"));
            user.setSignature((String) result.get("signature"));
            user.setPassword((String) result.get("password"));
            user.setUsername((String) result.get("username"));
            user.setCreated((int) result.get("created"));
            user.setUpdated((int) result.get("updated"));
            user.setId((int) result.get("id"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateUserById(UserModel userModel, int id) {
        String sql = "update user_model set username=?, password=?, email=?, status=?, signature=?";
        List<Object> params = new LinkedList<>();
        params.add(userModel.getUsername());
        params.add(userModel.getPassword());
        params.add(userModel.getEmail());
        params.add(userModel.getStatus());
        params.add(userModel.getSignature());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "delete from user_model where id=?";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            if (DBUtil.getInstance().updateByPreparedStatement(sql, params)) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        userModel.setUsername("test");
        userModel.setPassword("123456");
        userModel.setSignature("null");
        userModel.setStatus(0);
        userModel.setEmail("test@test.com");
        UserDao userDao = new UserDaoImpl();
        if (userDao.createUser(userModel)) {
            System.out.println("ok");
        }
    }
}
