package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class QuestionnaireItemEntity {

    @Id
    private Long id;
    private long itemId;
    private boolean isActive;
    private long parentId;
    private int priority;
    private long SupervisionId;
    private String text;
    private String type;
    private long answerHeaderId;
    private long answerQuestionnaryItemId;
    private float answerSystemPoint;
    private float answerUserPoint;
    private String answerValue;
    private boolean isShow;
    private long answerId;
    private String longitude;
    private String latitude;
    private boolean wantAnswere;
    private String description;
    @Generated(hash = 1636472868)
    public QuestionnaireItemEntity(Long id, long itemId, boolean isActive,
                                   long parentId, int priority, long SupervisionId, String text,
                                   String type, long answerHeaderId, long answerQuestionnaryItemId,
                                   float answerSystemPoint, float answerUserPoint, String answerValue,
                                   boolean isShow, long answerId, String longitude, String latitude,
                                   boolean wantAnswere, String description) {
        this.id = id;
        this.itemId = itemId;
        this.isActive = isActive;
        this.parentId = parentId;
        this.priority = priority;
        this.SupervisionId = SupervisionId;
        this.text = text;
        this.type = type;
        this.answerHeaderId = answerHeaderId;
        this.answerQuestionnaryItemId = answerQuestionnaryItemId;
        this.answerSystemPoint = answerSystemPoint;
        this.answerUserPoint = answerUserPoint;
        this.answerValue = answerValue;
        this.isShow = isShow;
        this.answerId = answerId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.wantAnswere = wantAnswere;
        this.description = description;
    }
    @Generated(hash = 64964288)
    public QuestionnaireItemEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getItemId() {
        return this.itemId;
    }
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    public boolean getIsActive() {
        return this.isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public long getParentId() {
        return this.parentId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    public int getPriority() {
        return this.priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public long getSupervisionId() {
        return this.SupervisionId;
    }
    public void setSupervisionId(long SupervisionId) {
        this.SupervisionId = SupervisionId;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public long getAnswerHeaderId() {
        return this.answerHeaderId;
    }
    public void setAnswerHeaderId(long answerHeaderId) {
        this.answerHeaderId = answerHeaderId;
    }
    public long getAnswerQuestionnaryItemId() {
        return this.answerQuestionnaryItemId;
    }
    public void setAnswerQuestionnaryItemId(long answerQuestionnaryItemId) {
        this.answerQuestionnaryItemId = answerQuestionnaryItemId;
    }
    public float getAnswerSystemPoint() {
        return this.answerSystemPoint;
    }
    public void setAnswerSystemPoint(float answerSystemPoint) {
        this.answerSystemPoint = answerSystemPoint;
    }
    public float getAnswerUserPoint() {
        return this.answerUserPoint;
    }
    public void setAnswerUserPoint(float answerUserPoint) {
        this.answerUserPoint = answerUserPoint;
    }
    public String getAnswerValue() {
        return this.answerValue;
    }
    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }
    public boolean getIsShow() {
        return this.isShow;
    }
    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }
    public long getAnswerId() {
        return this.answerId;
    }
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return this.latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public boolean getWantAnswere() {
        return this.wantAnswere;
    }
    public void setWantAnswere(boolean wantAnswere) {
        this.wantAnswere = wantAnswere;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
   
}
