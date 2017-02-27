package com.mapna.mapnaapp.models;

/**
 * Created by variani_h on 1/30/2017.
 */

public class Period {
    private int Id;
    private String name;

    public Period(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
