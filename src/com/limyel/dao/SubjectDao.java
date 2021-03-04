package com.limyel.dao;

import com.limyel.models.SubForumModel;

public interface SubjectDao {
    boolean createSubject(SubForumModel subForumModel);
    SubForumModel retriveSubjectById(int id);
    boolean updateSubjectById(SubForumModel subForumModel, int id);
    boolean deleteSubjectById(int id);
}
