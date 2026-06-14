package com.example.clinica.examen.robert.mapper;

import com.example.clinica.examen.robert.dto.AppointmentResponse;
import com.example.clinica.examen.robert.model.Appointment;

public class AppointmentMapper {
    public static AppointmentResponse AppointmentToDTO(Appointment appointment) {
        return new AppointmentResponse(appointment.getDate(), appointment.getScope(), appointment.getAppointmentStatus().toString(), appointment.getPatient().getFirstName(), appointment.getPatient().getLastName(), appointment.getPatient().getEmail(), appointment.getDoctor().getFirstName(), appointment.getDoctor().getLastName(), appointment.getDoctor().getEmail());
    }
}
