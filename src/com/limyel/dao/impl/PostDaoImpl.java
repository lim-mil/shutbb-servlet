package com.limyel.dao.impl;

import com.limyel.dao.PostDao;
import com.limyel.models.PostModel;
import com.limyel.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostDaoImpl implements PostDao {
    @Override
    public boolean createPost(PostModel postModel) {
        String sql = "insert into post_model (created, updated, title, content, user_id) values (?, ?, ?, ?, ?);";
        long ts = (long) System.currentTimeMillis();
        List<Object> params = new LinkedList<>();
        params.add(ts);
        params.add(ts);
        params.add(postModel.getTitle());
        params.add(postModel.getContent());
        params.add(postModel.getUserId());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public PostModel retrivePostById(int id) {
        Map<String, Object> result = new HashMap<>();
        PostModel postModel = new PostModel();
        String sql = "select * from post_model where id=?";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            result = DBUtil.getInstance().queryByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return postModel;
        }
        postModel.setId((int) result.get("id"));
        postModel.setCreated((long) result.get("created"));
        postModel.setUpdated((long) result.get("updated"));
        postModel.setTitle((String) result.get("title"));
        postModel.setContent((String) result.get("content"));
        postModel.setUserId((int) result.get("user_id"));

        return postModel;
    }

    @Override
    public boolean updatePostById(PostModel postModel, int id) {
        String sql = "update post_model set title=?, conten=? where id=?;";
        List<Object> params = new LinkedList<>();
        params.add(postModel.getTitle());
        params.add(postModel.getContent());
        params.add(id);
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletePostById(int id) {
        String sql = "delete from post_model where id=?;";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
