package com.project.fileops.common.data;

/**
 * created on: 08 12 2023
 * 12:13 pm
 */

public class FileCreatorInput {
    private String fileId;
    private String path;
    private byte[] content;
    private String userId;

    public FileCreatorInput(String fileId, String path, String userId, byte [] content) {
        this.fileId = fileId;
        this.path = path;
        this.userId = userId;
        this.content = content;
    }

    public String getFileId() {
        return fileId;
    }

    public String getPath() {
        return path;
    }

    public byte[] getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
