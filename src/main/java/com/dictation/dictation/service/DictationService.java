package com.dictation.dictation.service;

import com.dictation.dictation.domain.Dictation;

import java.util.List;

/**
 *
 */
public interface DictationService {
    void insertWord(Dictation dictation);

    void deleteWord(Integer id);

    List<Dictation> findAll();

    Dictation  findByid(Integer id);

    void updataid(Dictation dictation);
}
