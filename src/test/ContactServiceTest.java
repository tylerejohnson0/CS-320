package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import main.Contact;
import main.ContactService;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() { // before the tests are run create a Contact Service Object
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() { // tests to ensure that multiple new contact can be added to the hash map
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567892", "Jane", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.addContact(contact2);
        assertTrue(contactService.contacts.containsKey("1234567890"));
        assertEquals(contact, contactService.contacts.get("1234567890"));
        assertTrue(contactService.contacts.containsKey("1234567892"));
        assertEquals(contact2, contactService.contacts.get("1234567892"));
    }

    @Test
    public void testAddDuplicateContact() { // tests for exception to be trhown when inputing deplicate contact based on ContactID
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    public void testDeleteContact() { // tests to ensure hash map no longer contains a contact that has been deleted
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertFalse(contactService.contacts.containsKey("1234567890"));
    }

    @Test
    public void testDeleteNonexistentContact() { // tests for exception to be thrown when trying to delete a contact the does not exsist 
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("1234567890"));
    }

    @Test
    public void testUpdateContact() { // tests to ensure a contact can be updated with new properties 
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave");
        Contact updatedContact = contactService.contacts.get("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }
    @Test
    public void testUpdateContactFirstName() { // tests to ensure a contact can be updated with new properties 
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactFirstName("1234567890", "John");
        Contact updatedContact = contactService.contacts.get("1234567890");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactLastName() { // tests to ensure a contact can be updated with new properties 
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactLastName("1234567890", "Wilson");
        Contact updatedContact = contactService.contacts.get("1234567890");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Wilson", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactPhone() { // tests to ensure a contact can be updated with new properties 
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactPhone("1234567890", "0123456789");
        Contact updatedContact = contactService.contacts.get("1234567890");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("0123456789", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactAdress() { // tests to ensure a contact can be updated with new properties 
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactAddress("1234567890", "444 Alder Drive");
        Contact updatedContact = contactService.contacts.get("1234567890");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("444 Alder Drive", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() { // tests for exception to be thrown when trying to update a contact the does not exsist 
        assertThrows(IllegalArgumentException.class,
                () -> contactService.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Oak Ave"));
    }
}
