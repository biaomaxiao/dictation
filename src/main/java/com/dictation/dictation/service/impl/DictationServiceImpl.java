package com.dictation.dictation.service.impl;

import com.dictation.dictation.dao.DictationDao;
import com.dictation.dictation.domain.Dictation;
import com.dictation.dictation.service.DictationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DictationServiceImpl implements DictationService {

    @Autowired
    private DictationDao dictationDao;
    @Override
    public void insertWord(Dictation dictation) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        dictation.setCreationTime(sdf.format(new Date()));
        dictation.setDeletedState(0);
        dictationDao.insertWord(dictation);
    }

    @Override
    public void deleteWord(Integer id) {
        dictationDao.deleteWord(id);
    }

    @Override
    public List<Dictation> findAll() {
        return dictationDao.findAll();
    }

    @Override
    public List<Dictation> findByid(Integer id) {
        return dictationDao.findByid(id);
    }
}
