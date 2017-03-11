package com.franklyn.info.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGBOMA Franklyn on 3/23/2016.
 */
public class ContactsItems {

    private String logTag = ContactsItems.class.getSimpleName();

    public String name, developer, status;

    //list to insert
    private static List<ContactsItems> contactsItems = new ArrayList<>();

    public ContactsItems(String name, String developer, String status) {

        this.name = name;
        this.developer = developer;
        this.status = status;

    }

    //get Contact list.
    public static List<ContactsItems> getContactsList() {
        return contactsItems;
    }

    //add Contact to list.
    public static void add(String name, String developer, String status) {

        contactsItems.add(new ContactsItems(name, developer, status));
    }

    //get Contact total.
    public static int getContactSize() {
        return contactsItems.size();
    }
}
