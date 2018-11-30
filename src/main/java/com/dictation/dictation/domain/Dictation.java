package com.dictation.dictation.domain;

/**
 * @author zwr
 * @date 2018.11.30
 */

public class Dictation {
    private Integer id;
    private String word;//单词
    private String creationTime;//创建时间
    private Integer deletedState;//删除状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getDeletedState() {
        return deletedState;
    }

    public void setDeletedState(Integer deletedState) {
        this.deletedState = deletedState;
    }
}
