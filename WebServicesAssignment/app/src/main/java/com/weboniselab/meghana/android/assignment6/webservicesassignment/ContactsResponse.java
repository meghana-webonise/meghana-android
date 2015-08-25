package com.weboniselab.meghana.android.assignment6.webservicesassignment;

import java.util.List;

/**
 * Created by webonise on 25/8/15.
 */
public class ContactsResponse{
    List<Contacts> contacts;

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}
