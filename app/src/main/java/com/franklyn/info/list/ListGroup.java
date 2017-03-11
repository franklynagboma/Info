package com.franklyn.info.list;

import java.util.ArrayList;

/**
 * Created by AGBOMA Franklyn on 3/7/2016.
 */
public class ListGroup {

    private String group;
    private String gender;
    private static ArrayList<ListChild> childItem;

    public ListGroup(String group, String gender) {
        this.group = group;
        this.gender = gender;
    }

    public static void setChildItem(ArrayList<ListChild> item) {
        childItem = item;
    }

    public String getName() {
        return group;
    }

    public String getGender() {
        return gender;
    }

    public static ArrayList<ListChild> getChildItem() {
        return childItem;
    }
}
