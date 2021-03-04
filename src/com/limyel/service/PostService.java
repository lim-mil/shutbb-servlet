package com.limyel.service;

import com.limyel.models.TopicModel;

public interface PostService {
    boolean createPost(TopicModel topicModel);
    TopicModel retrivePostById(int id);
    boolean updatePostById(TopicModel topicModel, int id);
    boolean deletePostById(int id);
}
