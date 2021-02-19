package com.limyel.service;

import com.limyel.models.ReplyModel;

public interface ReplyService {
    boolean createReply(ReplyModel replyModel);
    ReplyModel retriveReplyById(int id);
    boolean updateReplyById(ReplyModel replyModel, int id);
    boolean deleteReplyById(int id);
}
