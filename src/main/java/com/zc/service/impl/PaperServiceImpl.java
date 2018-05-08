package com.zc.service.impl;

import com.zc.dao.PaperDao;
import com.zc.entity.Paper;
import com.zc.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperDao paperDao;
    public Paper findById(Long pid) {
        return paperDao.findById(pid);
    }

    public void update(Paper paper) {
        paperDao.update(paper);
    }

    public Long findSidById(Long pid) {
        return paperDao.findSidById(pid);
    }

    public void createNewPaper() {
       paperDao.createNewPaper();
    }

    public Paper findLatestPaper() {
        return paperDao.findLatestPaper();
    }

}
