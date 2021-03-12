package com.limyel.shutbb_servlet.dao.impl;

import com.limyel.shutbb_servlet.dao.ReplyDao;
import com.limyel.shutbb_servlet.models.PostModel;
import com.limyel.shutbb_servlet.utils.DBUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
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
        params.add(postModel.getTopicId());
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
        postModel.setUpdated((Timestamp) result.get("updated"));
        postModel.setCreated((Timestamp) result.get("created"));
        postModel.setContent((String) result.get("Content"));
        postModel.setUserId((int) result.get("user_id"));
        postModel.setTopicId((int) result.get("post_id"));

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
