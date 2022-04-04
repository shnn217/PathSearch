package com.example.pathsearch.datamodel;

import java.util.UUID;

public class FinalInput {
    private Integer id;
    private String name;
    private Integer parent_id;
    private String path;
    private String type;

    public FinalInput(Integer id, String name, Integer parent_id, String path, String type) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.path = path;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
