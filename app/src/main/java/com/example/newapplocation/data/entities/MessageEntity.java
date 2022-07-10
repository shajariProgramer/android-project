package com.example.newapplocation.data.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class MessageEntity {
    @Id
    private Long id;
    private Long chatMemberId;
    private String message;
    private String messageType;
    private Long chatHistoryId;
    private String fileDirection;
    private String type;
    private String uuId;
    private Long chatId;
    private Long personIdMember;
    private String fileName;
    private String extention;
    private String fileType;
    private byte[] binaryFile;

    public byte[] getBinaryFile() {
        return binaryFile;
    }

    public void setBinaryFile(byte[] binaryFile) {
        this.binaryFile = binaryFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getPersonIdMember() {
        return personIdMember;
    }

    public void setPersonIdMember(Long personIdMember) {
        this.personIdMember = personIdMember;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileDirection() {
        return fileDirection;
    }

    public void setFileDirection(String fileDirection) {
        this.fileDirection = fileDirection;
    }

    public Long getChatMemberId() {
        return chatMemberId;
    }

    public void setChatMemberId(Long chatMemberId) {
        this.chatMemberId = chatMemberId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Long getChatHistoryId() {
        return chatHistoryId;
    }

    public void setChatHistoryId(Long chatHistoryId) {
        this.chatHistoryId = chatHistoryId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 296257970)
    public MessageEntity(Long id, Long chatMemberId, String message, String messageType, Long chatHistoryId,
                         String fileDirection, String type, String uuId, Long chatId, Long personIdMember, String fileName,
                         String extention, String fileType, byte[] binaryFile) {
        this.id = id;
        this.chatMemberId = chatMemberId;
        this.message = message;
        this.messageType = messageType;
        this.chatHistoryId = chatHistoryId;
        this.fileDirection = fileDirection;
        this.type = type;
        this.uuId = uuId;
        this.chatId = chatId;
        this.personIdMember = personIdMember;
        this.fileName = fileName;
        this.extention = extention;
        this.fileType = fileType;
        this.binaryFile = binaryFile;
    }

    @Generated(hash = 1797882234)
    public MessageEntity() {
    }

}
