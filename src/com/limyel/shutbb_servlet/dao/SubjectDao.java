package com.limyel.shutbb_servlet.dao;

import com.limyel.shutbb_servlet.models.SubForumModel;

public interface SubjectDao {
    boolean createSubject(SubForumModel subForumModel);
    SubForumModel retriveSubjectById(int id);
    boolean updateSubjectById(SubForumModel subForumModel, int id);
    boolean deleteSubjectById(int id);
}
