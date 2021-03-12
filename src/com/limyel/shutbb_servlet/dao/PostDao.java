package com.limyel.shutbb_servlet.dao;

import com.limyel.shutbb_servlet.models.TopicModel;

public interface PostDao {
    boolean createPost(TopicModel topicModel);
    TopicModel retrivePostById(int id);
    boolean updatePostById(TopicModel topicModel, int id);
    boolean deletePostById(int id);
}
