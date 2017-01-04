package com.mapna.mapnaapp.models;

/**
 * Created by variani_h
 */

public class DrawerListItem {

    private String title ;
    private int icon;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public DrawerListItem() {
    }

    public DrawerListItem(String title, int icon, int counter) {
        this.title = title;
        this.icon = icon;
    }
}
