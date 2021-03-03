package com.limyel.dao;

import com.limyel.models.SectionModel;

public interface SectionDao {
    boolean createSection(SectionModel sectionModel);
    SectionModel retriveSectionById(int id);
    boolean updateSectionById(SectionModel sectionModel, int id);
    boolean deleteSectionById(int id);
}
