package com.dictation.dictation.service.impl;

import com.dictation.dictation.dao.DictationDao;
import com.dictation.dictation.domain.Dictation;
import com.dictation.dictation.service.DictationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictationServiceImpl implements DictationService {

    @Autowired
    private DictationDao dictationDao;
    @Override
    public void insertWord(Dictation dictation) {
        dictationDao.insertWord(dictation);
    }

    @Override
    public void deleteWord(Dictation dictation) {
        dictationDao.deleteWord(dictation);
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
