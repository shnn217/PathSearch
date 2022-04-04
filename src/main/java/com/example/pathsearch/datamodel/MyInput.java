package com.example.pathsearch.datamodel;

public class MyInput {
    private String name;
    private String preD;
    private String type;
    private String path;

    public MyInput(String name, String preD, String type, String path) {
        this.name = name;
        this.preD = preD;
        this.type = type;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreD() {
        return preD;
    }

    public void setPreD(String preD) {
        this.preD = preD;
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
