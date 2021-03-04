package com.limyel.dao;

import com.limyel.models.TopicModel;

public interface PostDao {
    boolean createPost(TopicModel topicModel);
    TopicModel retrivePostById(int id);
    boolean updatePostById(TopicModel topicModel, int id);
    boolean deletePostById(int id);
}
