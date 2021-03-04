package com.limyel.service;

import com.limyel.models.PostModel;

public interface ReplyService {
    boolean createReply(PostModel postModel);
    PostModel retriveReplyById(int id);
    boolean updateReplyById(PostModel postModel, int id);
    boolean deleteReplyById(int id);
}
