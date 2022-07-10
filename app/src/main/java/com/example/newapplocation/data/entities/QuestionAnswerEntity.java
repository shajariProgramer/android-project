package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class QuestionAnswerEntity {

    String id;
    String title;
    boolean isActive;
    int priority;
    long questionId;
    long questionaryId;
    @Generated(hash = 1968118145)
    public QuestionAnswerEntity(String id, String title, boolean isActive,
                                int priority, long questionId, long questionaryId) {
        this.id = id;
        this.title = title;
        this.isActive = isActive;
        this.priority = priority;
        this.questionId = questionId;
        this.questionaryId = questionaryId;
    }
    @Generated(hash = 2054364113)
    public QuestionAnswerEntity() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean getIsActive() {
        return this.isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public int getPriority() {
        return this.priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public long getQuestionId() {
        return this.questionId;
    }
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
    public long getQuestionaryId() {
        return this.questionaryId;
    }
    public void setQuestionaryId(long questionaryId) {
        this.questionaryId = questionaryId;
    }

}
