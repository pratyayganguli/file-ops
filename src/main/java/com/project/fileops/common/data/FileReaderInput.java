package com.project.fileops.common.data;

/**
 * created on: 08 12 2023
 * 10:59 am
 */

public class FileReaderInput {
    private String fileId;
    private String path;

    public FileReaderInput(String fileId, String path) {
        this.fileId = fileId;
        this.path = path;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
