package main;

public class Contact { // Contact class
    private final String contactId; // unique contact ID String that is non updatable
    private String firstName; // firstName string
    private String lastName; // lastName string
    private String phone; // phone string
    private String address; // contact string

    // constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) { // contactId must not be null or have a length greater than 10
            throw new IllegalArgumentException("Invalid Contact Id");
        }
        if (firstName == null || firstName.length() > 10) { // firstName must not be null or have a length greater than 10
            throw new IllegalArgumentException("Invalid First Name");
        }
        if (lastName == null || lastName.length() > 10) { // lastName must not be null or have a length greater than 10
            throw new IllegalArgumentException("Invalid Last Name");
        }
        if (phone == null || phone.length() != 10) { // phone must not be null or have a length different than 10
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        if (address == null || address.length() >= 30) { // address must not be null or have a length less than 30
            throw new IllegalArgumentException("Invalid Address");
        }
        
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // setters
    public void setFirstName(String firstName) {
        validateNames(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() >= 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }

    private void validateNames(String name) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        return;
    }
}
