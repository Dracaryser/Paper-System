package com.zc.dao;

import com.zc.entity.Paper;

public interface PaperDao {

    Paper findById(Long pid);

    void update(Paper paper);

    Long findSidById(Long pid);

    void createNewPaper();

    Paper findLatestPaper();
}
