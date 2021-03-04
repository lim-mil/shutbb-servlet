package com.limyel.service.impl;

import com.limyel.dao.ReplyDao;
import com.limyel.dao.impl.ReplyDaoImpl;
import com.limyel.models.PostModel;
import com.limyel.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao = new ReplyDaoImpl();

    @Override
    public boolean createReply(PostModel postModel) {
        return replyDao.createReply(postModel);
    }

    @Override
    public PostModel retriveReplyById(int id) {
        return replyDao.retriveReplyById(id);
    }

    @Override
    public boolean updateReplyById(PostModel postModel, int id) {
        return replyDao.updateReplyById(postModel, id);
    }

    @Override
    public boolean deleteReplyById(int id) {
        return replyDao.deleteReplyById(id);
    }
}
