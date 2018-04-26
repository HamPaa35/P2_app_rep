package com.example.pjevs.projecttest1;

public class Storage extends FileManager {

    private String name;

    public Storage(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
