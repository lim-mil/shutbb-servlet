package com.limyel.shutbb_servlet.service.impl;

import com.limyel.shutbb_servlet.dao.PostDao;
import com.limyel.shutbb_servlet.dao.impl.PostDaoImpl;
import com.limyel.shutbb_servlet.models.TopicModel;
import com.limyel.shutbb_servlet.service.PostService;

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
