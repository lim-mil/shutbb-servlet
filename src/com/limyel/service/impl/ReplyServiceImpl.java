package com.limyel.service.impl;

import com.limyel.dao.ReplyDao;
import com.limyel.dao.impl.ReplyDaoImpl;
import com.limyel.models.ReplyModel;
import com.limyel.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao = new ReplyDaoImpl();

    @Override
    public boolean createReply(ReplyModel replyModel) {
        return replyDao.createReply(replyModel);
    }

    @Override
    public ReplyModel retriveReplyById(int id) {
        return replyDao.retriveReplyById(id);
    }

    @Override
    public boolean updateReplyById(ReplyModel replyModel, int id) {
        return replyDao.updateReplyById(replyModel, id);
    }

    @Override
    public boolean deleteReplyById(int id) {
        return replyDao.deleteReplyById(id);
    }
}
