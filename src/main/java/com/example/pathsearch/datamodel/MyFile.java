package com.example.pathsearch.datamodel;

public class MyFile {
    private int fileId;
    private String fileName;
    private Integer folderId;
    private String path;

    public MyFile(int fileId, String fileName, Integer folderId, String path) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.folderId = folderId;
        this.path = path;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
