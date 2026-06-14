package com.example.clinica.examen.robert.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String scope;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "doctor_id"
    )
    private Doctor doctor;
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "patient_id"
    )
    private Patient patient;

    public Appointment() {
    }

    public Appointment(LocalDate date, String scope, AppointmentStatus appointmentStatus, Doctor doctor, Patient patient) {
        this.date = date;
        this.scope = scope;
        this.appointmentStatus = appointmentStatus;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
