package com.limyel.dao;

import com.limyel.models.PostModel;

public interface PostDao {
    boolean createPost(PostModel postModel);
    PostModel retrivePostById(int id);
    boolean updatePostById(PostModel postModel, int id);
    boolean deletePostById(int id);
}
