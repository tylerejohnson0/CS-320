package main;

import java.util.Date;

public class Appointment { // Appointment class
    private final String appointmentId; // unique appointmentId string that is non updatable
    private Date appointmentDate; // appointmentDate date
    private String description; // description string

    // constrctor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) { // appointmentId must not be null or have a length greater than 10
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) { // appointmentDate must not be null or in the past
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) { // description must not be null or have a length greater than 50
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // setters
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
