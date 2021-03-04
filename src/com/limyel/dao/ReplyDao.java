package com.limyel.dao;

import com.limyel.models.PostModel;

public interface ReplyDao {
    boolean createReply(PostModel postModel);
    PostModel retriveReplyById(int id);
    boolean updateReplyById(PostModel postModel, int id);
    boolean deleteReplyById(int id);
}
