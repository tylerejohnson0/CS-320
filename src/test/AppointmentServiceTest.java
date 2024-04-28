package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.Appointment;
import main.AppointmentService;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @Before
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("1234567890", appointmentDate, "Appointment Description");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.appointments.containsKey("1234567890"));
        assertEquals(appointment, appointmentService.appointments.get("1234567890"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment1 = new Appointment("1234567890", appointmentDate, "Appointment Description");
        Appointment appointment2 = new Appointment("1234567890", appointmentDate, "Another Description");
        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment2));
    }

    @Test
    public void testDeleteAppointment() {
        Date appointmentDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("1234567890", appointmentDate, "Appointment Description");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("1234567890");
        assertFalse(appointmentService.appointments.containsKey("1234567890"));
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("1234567890"));
    }
}
