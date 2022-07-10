package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class SupervisionEntity {
    @Id
    private Long id;
    private long supervisionId;
    private long personId;
    private long referenceId;
    private long referenceType;
    private String status;
    private long systemChartId;
    private String projectCode;
    private long projectId;
    private String projectTitle;
    private String projectType;
    private long questionnaireId;
    private String questionnaireTitle;
    private String systemObjectCode;
    private String createdAt;
    private String userId;
    private boolean isShow;
    private String description;
    @Generated(hash = 461558122)
    public SupervisionEntity(Long id, long supervisionId, long personId,
                             long referenceId, long referenceType, String status, long systemChartId,
                             String projectCode, long projectId, String projectTitle,
                             String projectType, long questionnaireId, String questionnaireTitle,
                             String systemObjectCode, String createdAt, String userId,
                             boolean isShow, String description) {
        this.id = id;
        this.supervisionId = supervisionId;
        this.personId = personId;
        this.referenceId = referenceId;
        this.referenceType = referenceType;
        this.status = status;
        this.systemChartId = systemChartId;
        this.projectCode = projectCode;
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectType = projectType;
        this.questionnaireId = questionnaireId;
        this.questionnaireTitle = questionnaireTitle;
        this.systemObjectCode = systemObjectCode;
        this.createdAt = createdAt;
        this.userId = userId;
        this.isShow = isShow;
        this.description = description;
    }
    @Generated(hash = 1074456415)
    public SupervisionEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getSupervisionId() {
        return this.supervisionId;
    }
    public void setSupervisionId(long supervisionId) {
        this.supervisionId = supervisionId;
    }
    public long getPersonId() {
        return this.personId;
    }
    public void setPersonId(long personId) {
        this.personId = personId;
    }
    public long getReferenceId() {
        return this.referenceId;
    }
    public void setReferenceId(long referenceId) {
        this.referenceId = referenceId;
    }
    public long getReferenceType() {
        return this.referenceType;
    }
    public void setReferenceType(long referenceType) {
        this.referenceType = referenceType;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public long getSystemChartId() {
        return this.systemChartId;
    }
    public void setSystemChartId(long systemChartId) {
        this.systemChartId = systemChartId;
    }
    public String getProjectCode() {
        return this.projectCode;
    }
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public long getProjectId() {
        return this.projectId;
    }
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
    public String getProjectTitle() {
        return this.projectTitle;
    }
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }
    public String getProjectType() {
        return this.projectType;
    }
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    public long getQuestionnaireId() {
        return this.questionnaireId;
    }
    public void setQuestionnaireId(long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    public String getQuestionnaireTitle() {
        return this.questionnaireTitle;
    }
    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }
    public String getSystemObjectCode() {
        return this.systemObjectCode;
    }
    public void setSystemObjectCode(String systemObjectCode) {
        this.systemObjectCode = systemObjectCode;
    }
    public String getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public boolean getIsShow() {
        return this.isShow;
    }
    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
