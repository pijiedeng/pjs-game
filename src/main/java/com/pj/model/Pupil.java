package com.pj.model;

/**
 * Created on 2019/5/13 17:23
 * 小学生类
 * class of pupil
 * @author pj Deng
 */
public class Pupil {
    /**
     * 学生所在位置编号
     */
    private Integer index;
    /**
     * 学生说出的内容
     */
    private String speakWords;

    //constructor

    public Pupil() {
    }

    public Pupil(Integer index, String speakWords) {
        this.index = index;
        this.speakWords = speakWords;
    }

    //setter and getter

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSpeakWords() {
        return speakWords;
    }

    public void setSpeakWords(String speakWords) {
        this.speakWords = speakWords;
    }
}
