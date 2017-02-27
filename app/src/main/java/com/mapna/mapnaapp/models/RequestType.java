package com.mapna.mapnaapp.models;

import java.util.List;

/**
 * Created by variani_h on 1/29/2017.
 */

public class RequestType {
    private String Id;
    private String name;

    public RequestType(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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
        return name;
    }

}
