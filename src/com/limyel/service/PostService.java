package com.limyel.service;

import com.limyel.models.PostModel;

public interface PostService {
    boolean createPost(PostModel postModel);
    PostModel retrivePostById(int id);
    boolean updatePostById(PostModel postModel, int id);
    boolean deletePostById(int id);
}
