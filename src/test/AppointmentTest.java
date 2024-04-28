package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Date;

import org.junit.Test;

import main.Appointment;

public class AppointmentTest {
    @Test
    public void testValidAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000); // Tomorrow's date
        Appointment appointment = new Appointment("1234567890", appointmentDate, "Appointment Description");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals("Appointment Description", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment(null, appointmentDate, "Appointment Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("12345678901", appointmentDate, "Appointment Description"));
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Yesterday's date
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1234567890", null, "Appointment Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Appointment("1234567890", pastDate, "Appointment Description"));
    }

    @Test
    public void testInvalidDescription() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", appointmentDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1234567890", appointmentDate,
                "This is a very long description that exceeds the maximum allowed length"));
    }

    @Test
    public void testUpdateAppointmentDate() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        Date newAppointmentDate = new Date(System.currentTimeMillis() + 172800000); // Two days from now
        Appointment appointment = new Appointment("1234567890", appointmentDate, "Appointment Description");
        appointment.setAppointmentDate(newAppointmentDate);
        assertEquals(newAppointmentDate, appointment.getAppointmentDate());
    }

    @Test
    public void testUpdateDescription() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("1234567890", appointmentDate, "Appointment Description");
        appointment.setDescription("New Appointment Description");
        assertEquals("New Appointment Description", appointment.getDescription());
    }
}
