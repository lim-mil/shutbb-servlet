package com.limyel.shutbb_servlet.dao;

import com.limyel.shutbb_servlet.models.SectionModel;

public interface SectionDao {
    boolean createSection(SectionModel sectionModel);
    SectionModel retriveSectionById(int id);
    boolean updateSectionById(SectionModel sectionModel, int id);
    boolean deleteSectionById(int id);
}
