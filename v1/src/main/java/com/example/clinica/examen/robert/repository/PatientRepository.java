package com.example.clinica.examen.robert.repository;

import com.example.clinica.examen.robert.model.Doctor;
import com.example.clinica.examen.robert.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
}
