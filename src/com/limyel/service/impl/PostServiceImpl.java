package com.limyel.service.impl;

import com.limyel.dao.PostDao;
import com.limyel.dao.impl.PostDaoImpl;
import com.limyel.models.TopicModel;
import com.limyel.service.PostService;

public class PostServiceImpl implements PostService {
    private PostDao postDao = new PostDaoImpl();

    @Override
    public boolean createPost(TopicModel topicModel) {
        return postDao.createPost(topicModel);
    }

    @Override
    public TopicModel retrivePostById(int id) {
        return postDao.retrivePostById(id);
    }

    @Override
    public boolean updatePostById(TopicModel topicModel, int id) {
        return postDao.updatePostById(topicModel, id);
    }

    @Override
    public boolean deletePostById(int id) {
        return postDao.deletePostById(id);
    }
}
