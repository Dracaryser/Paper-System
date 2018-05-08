package com.zc.service;

import com.zc.entity.Paper;

public interface PaperService {
    Paper findById(Long pid);

    void update(Paper paper);

    Long findSidById(Long pid);

    void createNewPaper();

    Paper findLatestPaper();
}
