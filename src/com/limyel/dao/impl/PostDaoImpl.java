package com.limyel.dao.impl;

import com.limyel.dao.PostDao;
import com.limyel.models.TopicModel;
import com.limyel.utils.DBUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PostDaoImpl implements PostDao {
    @Override
    public boolean createPost(TopicModel topicModel) {
        String sql = "insert into post_model (created, updated, title, content, user_id) values (?, ?, ?, ?, ?);";
        long ts = (long) System.currentTimeMillis();
        List<Object> params = new LinkedList<>();
        params.add(ts);
        params.add(ts);
        params.add(topicModel.getTitle());
        params.add(topicModel.getContent());
        params.add(topicModel.getUserId());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public TopicModel retrivePostById(int id) {
        Map<String, Object> result = new HashMap<>();
        TopicModel topicModel = new TopicModel();
        String sql = "select * from post_model where id=?";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            result = DBUtil.getInstance().queryByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return topicModel;
        }
        topicModel.setId((int) result.get("id"));
        topicModel.setCreated((long) result.get("created"));
        topicModel.setUpdated((long) result.get("updated"));
        topicModel.setTitle((String) result.get("title"));
        topicModel.setContent((String) result.get("content"));
        topicModel.setUserId((int) result.get("user_id"));

        return topicModel;
    }

    @Override
    public boolean updatePostById(TopicModel topicModel, int id) {
        String sql = "update post_model set title=?, conten=? where id=?;";
        List<Object> params = new LinkedList<>();
        params.add(topicModel.getTitle());
        params.add(topicModel.getContent());
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
