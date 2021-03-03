package com.limyel.dao.impl;

import com.limyel.dao.SubjectDao;
import com.limyel.models.SubjectModel;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public boolean createSubject(SubjectModel subjectModel) {
        return false;
    }

    @Override
    public SubjectModel retriveSubjectById(int id) {
        return null;
    }

    @Override
    public boolean updateSubjectById(SubjectModel subjectModel, int id) {
        return false;
    }

    @Override
    public boolean deleteSubjectById(int id) {
        return false;
    }
}
