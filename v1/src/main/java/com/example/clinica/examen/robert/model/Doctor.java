package com.example.clinica.examen.robert.model;

import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String email;
    private String medicalDepartment;

    public Doctor() {
    }

    public Doctor(String lastName, String firstName, String email, String medicalDepartment) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.medicalDepartment = medicalDepartment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedicalDepartment() {
        return medicalDepartment;
    }

    public void setMedicalDepartment(String medicalDepartment) {
        this.medicalDepartment = medicalDepartment;
    }
}
