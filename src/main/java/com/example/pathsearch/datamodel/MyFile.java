package com.example.pathsearch.datamodel;

public class MyFile {

    private String fileName;
    private String path;
    private String type;

    public MyFile(String fileName, String path, String type) {

        this.fileName = fileName;
        this.path = path;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
