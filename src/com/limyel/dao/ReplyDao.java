package com.limyel.dao;

import com.limyel.models.ReplyModel;

public interface ReplyDao {
    boolean createReply(ReplyModel replyModel);
    ReplyModel retriveReplyById(int id);
    boolean updateReplyById(ReplyModel replyModel, int id);
    boolean deleteReplyById(int id);
}
