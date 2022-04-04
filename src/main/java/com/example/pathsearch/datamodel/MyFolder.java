package com.example.pathsearch.datamodel;

public class MyFolder {

    private String folderName;
    private String path;
    private String type;

    public MyFolder(String folderName, String path, String type) {
        this.folderName = folderName;
        this.path = path;
        this.type = type;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
