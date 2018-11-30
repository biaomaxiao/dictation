package com.dictation.dictation.dao;

import com.dictation.dictation.domain.Dictation;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictationDao {
    /**
     * 增加单词
     * @param dictation
     */
    void insertWord(Dictation dictation);

    /**
     * 删除单词
     */
    void  deleteWord(Dictation dictation);

    /**
     * 查询所有单词
     */
    List<Dictation> findAll();

    /**
     * 根据id查询单词
     */
    List<Dictation>  findByid(Integer id);
}
