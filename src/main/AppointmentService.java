package main;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    public final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        String appointmentId = appointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " already exists");
        }
        appointments.put(appointmentId, appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " does not exist");
        }
        appointments.remove(appointmentId);
    }

    public void updateTaskNameById(String taskID, String name) {

    }

    public void updateTaskDescriptionById(String taskID, String description) {
        
    }
}