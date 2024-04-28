package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.Contact;

public class ContactTest {
    @Test
    public void testValidContact() { // tests to ensure constructor works as intened by giving the Contact constructor a normal set of arguments and calling the getters to verify 
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("First", contact.getFirstName());
        assertEquals("Last", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() { // tests to ensure exception is thrown when giving an invalid contactId String to the constructor
        assertThrows(IllegalArgumentException.class, // cannot be null
                () -> new Contact(null, "First", "Last", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, // cannot be longer than 10 characters
                () -> new Contact("12345678901", "First", "Last", "1234567890", "123 Main St"));
            
    }

    @Test
    public void testInvalidFirstName() { // tests to ensure exception is thrown when giving an invalid firstName String
        assertThrows(IllegalArgumentException.class, // cannot be null
                () -> new Contact("1234567890", null, "Last", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, // cannot be longer than 10 characters
                () -> new Contact("1234567890", "FirstLongName", "Last", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidLastName() { // tests to ensure exception is thrown when giving an invalid lastName String 
        assertThrows(IllegalArgumentException.class, // cannot be null
                () -> new Contact("1234567890", "First", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, // cannot be longer than 10 characters
                () -> new Contact("1234567890", "First", "LastLongName", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidPhone() { // tests to ensure exception is thrown when giving an invalid phone String 
        assertThrows(IllegalArgumentException.class, // cannot be null
                () -> new Contact("1234567890", "First", "Last", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, // cannot be longer than 10  characters
                () -> new Contact("1234567890", "First", "Last", "12345678901", "123 Main St"));
        assertThrows(IllegalArgumentException.class, // cannot be less than than 10  characters
                () -> new Contact("1234567890", "First", "Last", "12345", "123 Main St"));
    }

    @Test
    public void testInvalidAddress() { // tests to ensure exception is thrown when giving an invalid address String 
        assertThrows(IllegalArgumentException.class, // cannot be null
                () -> new Contact("1234567890", "First", "Last", "1234567890", null));
        assertThrows(IllegalArgumentException.class, // cannot be longer than 30 characters
                () -> new Contact("1234567890", "First", "Last", "1234567890", "123 Main St This is a long address"));
    }

    @Test
    public void testUpdateFirstName() { // tests to ensure a contact's firstName can be updated wth setter
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        contact.setFirstName("NewFirst");
        assertEquals("NewFirst", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() { // tests to ensure a contact's lastName can be updated wth setter
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() { // tests to ensure a contact's phone can be updated wth setter
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() { // tests to ensure a contact's address can be updated wth setter
        Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}
