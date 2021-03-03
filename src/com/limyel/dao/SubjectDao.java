package com.limyel.dao;

import com.limyel.models.SubjectModel;

public interface SubjectDao {
    boolean createSubject(SubjectModel subjectModel);
    SubjectModel retriveSubjectById(int id);
    boolean updateSubjectById(SubjectModel subjectModel, int id);
    boolean deleteSubjectById(int id);
}
