package com.limyel.shutbb_servlet.dao.impl;

import com.limyel.shutbb_servlet.dao.SubjectDao;
import com.limyel.shutbb_servlet.models.SubForumModel;

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
