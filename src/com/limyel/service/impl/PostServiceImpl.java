package com.limyel.service.impl;

import com.limyel.dao.PostDao;
import com.limyel.dao.impl.PostDaoImpl;
import com.limyel.models.PostModel;
import com.limyel.service.PostService;

public class PostServiceImpl implements PostService {
    private PostDao postDao = new PostDaoImpl();

    @Override
    public boolean createPost(PostModel postModel) {
        return postDao.createPost(postModel);
    }

    @Override
    public PostModel retrivePostById(int id) {
        return postDao.retrivePostById(id);
    }

    @Override
    public boolean updatePostById(PostModel postModel, int id) {
        return postDao.updatePostById(postModel, id);
    }

    @Override
    public boolean deletePostById(int id) {
        return postDao.deletePostById(id);
    }
}
