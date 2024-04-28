package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService { // ContactService class
    public final Map<String, Contact> contacts = new HashMap<>(); // hash map to store contacts 

    public void addContact(Contact contact) { // addContact method to add contact to hasp map with unique ID
        String contactId = contact.getContactId();
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with Id" + contactId + " already exsts");
        }
        contacts.put(contactId, contact);
    }

    public void deleteContact(String contactId) { // deleteContact method to delete contacts from HashMap
        if (!contacts.containsKey(contactId)) { // throws exception if hash map does not contain contact based on the contact ID
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, 
     String lastName, String phone, String address) {
        // updateContact method to update contacts from HashMap using unique ID to identify correct contact
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " does not exist");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    public void updateContactFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
    }
    public void updateContactLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (lastName != null) {
            contact.setLastName(lastName);
        }
    }
    public void updateContactPhone(String contactId, String phone) { 
        Contact contact = contacts.get(contactId);
        if (phone != null) {
            contact.setPhone(phone);
        }
    }
    public void updateContactAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (address != null) {
            contact.setAddress(address);
        }
    }
}
