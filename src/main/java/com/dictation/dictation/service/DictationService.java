package com.dictation.dictation.service;

import com.dictation.dictation.domain.Dictation;

import java.util.List;

public interface DictationService {
    void insertWord(Dictation dictation);

    void deleteWord(Dictation dictation);

    List<Dictation> findAll();

    List<Dictation>  findByid(Integer id);
}
