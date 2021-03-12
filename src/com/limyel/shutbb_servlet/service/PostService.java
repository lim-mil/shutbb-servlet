package com.limyel.shutbb_servlet.service;

import com.limyel.shutbb_servlet.models.TopicModel;

public interface PostService {
    boolean createPost(TopicModel topicModel);
    TopicModel retrivePostById(int id);
    boolean updatePostById(TopicModel topicModel, int id);
    boolean deletePostById(int id);
}
