package com.example.clinica.examen.robert.service;

import com.example.clinica.examen.robert.dto.AppointmentResponse;
import com.example.clinica.examen.robert.mapper.AppointmentMapper;
import com.example.clinica.examen.robert.repository.AppointmentRepository;
import com.example.clinica.examen.robert.repository.DoctorRepository;
import com.example.clinica.examen.robert.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<AppointmentResponse> getAllAppointments() {
        return (List)this.appointmentRepository.findAll().stream().map(AppointmentMapper::AppointmentToDTO).collect(Collectors.toList());
    }
}
