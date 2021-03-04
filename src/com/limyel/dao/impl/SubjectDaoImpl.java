package com.limyel.dao.impl;

import com.limyel.dao.SubjectDao;
import com.limyel.models.SubForumModel;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public boolean createSubject(SubForumModel subForumModel) {
        return false;
    }

    @Override
    public SubForumModel retriveSubjectById(int id) {
        return null;
    }

    @Override
    public boolean updateSubjectById(SubForumModel subForumModel, int id) {
        return false;
    }

    @Override
    public boolean deleteSubjectById(int id) {
        return false;
    }
}
