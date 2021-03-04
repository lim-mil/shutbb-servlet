package com.limyel.dao.impl;

import com.limyel.dao.ReplyDao;
import com.limyel.models.PostModel;
import com.limyel.utils.DBUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public boolean createReply(PostModel postModel) {
        long ts = (long) System.currentTimeMillis();
        String sql = "create reply_model (created, updated, content, user_id, post_id) values (?, ?, ?, ?, ?);";
        List<Object> params = new LinkedList<>();
        params.add(ts);
        params.add(ts);
        params.add(postModel.getContent());
        params.add(postModel.getUserId());
        params.add(postModel.getPostId());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public PostModel retriveReplyById(int id) {
        PostModel postModel = new PostModel();
        Map<String, Object> result = new HashMap<>();
        String sql = "select * from reply_model where id=?";
        List<Object> params = new LinkedList<>();
        params.add(id);
        try {
            result = DBUtil.getInstance().queryByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        postModel.setId((int) result.get("id"));
        postModel.setUpdated((long) result.get("updated"));
        postModel.setCreated((long) result.get("created"));
        postModel.setContent((String) result.get("Content"));
        postModel.setUserId((int) result.get("user_id"));
        postModel.setPostId((int) result.get("post_id"));

        return postModel;
    }

    @Override
    public boolean updateReplyById(PostModel postModel, int id) {
        String sql = "update reply_model set content=? where id=?;";
        List<Object> params = new LinkedList<>();
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
    public boolean deleteReplyById(int id) {
        String sql = "delete from reply_model where id=?;";
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
