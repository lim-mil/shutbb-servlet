package com.limyel.shutbb_servlet.service;

import com.limyel.shutbb_servlet.models.PostModel;

public interface ReplyService {
    boolean createReply(PostModel postModel);
    PostModel retriveReplyById(int id);
    boolean updateReplyById(PostModel postModel, int id);
    boolean deleteReplyById(int id);
}
