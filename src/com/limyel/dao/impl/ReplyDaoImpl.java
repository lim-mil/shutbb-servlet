package com.limyel.dao.impl;

import com.limyel.dao.ReplyDao;
import com.limyel.models.ReplyModel;
import com.limyel.utils.DBUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReplyDaoImpl implements ReplyDao {
    @Override
    public boolean createReply(ReplyModel replyModel) {
        long ts = (long) System.currentTimeMillis();
        String sql = "create reply_model (created, updated, content, user_id, post_id) values (?, ?, ?, ?, ?);";
        List<Object> params = new LinkedList<>();
        params.add(ts);
        params.add(ts);
        params.add(replyModel.getContent());
        params.add(replyModel.getUserId());
        params.add(replyModel.getPostId());
        try {
            return DBUtil.getInstance().updateByPreparedStatement(sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public ReplyModel retriveReplyById(int id) {
        ReplyModel replyModel = new ReplyModel();
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
        replyModel.setId((int) result.get("id"));
        replyModel.setUpdated((long) result.get("updated"));
        replyModel.setCreated((long) result.get("created"));
        replyModel.setContent((String) result.get("Content"));
        replyModel.setUserId((int) result.get("user_id"));
        replyModel.setPostId((int) result.get("post_id"));

        return replyModel;
    }

    @Override
    public boolean updateReplyById(ReplyModel replyModel, int id) {
        String sql = "update reply_model set content=? where id=?;";
        List<Object> params = new LinkedList<>();
        params.add(replyModel.getContent());
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
