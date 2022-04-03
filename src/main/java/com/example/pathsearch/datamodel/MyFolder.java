package com.example.pathsearch.datamodel;

public class MyFolder {
    private int folderId;
    private String folderName;
    private Integer parentId;
    private String path;

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MyFolder(int folderId, String folderName, Integer parentId, String path) {
        this.folderId = folderId;
        this.folderName = folderName;
        this.parentId = parentId;
        this.path = path;
    }
}
