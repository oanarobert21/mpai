package com.example.clinica.examen.robert.config;

import com.example.clinica.examen.robert.model.Appointment;
import com.example.clinica.examen.robert.model.AppointmentStatus;
import com.example.clinica.examen.robert.model.Doctor;
import com.example.clinica.examen.robert.model.Patient;
import com.example.clinica.examen.robert.repository.AppointmentRepository;
import com.example.clinica.examen.robert.repository.DoctorRepository;
import com.example.clinica.examen.robert.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public DataInitializer(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void loadAppointmentData() {
        if (this.appointmentRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/appointments.txt")).getInputStream()))) {
                    while((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            LocalDate appointmentDate = LocalDate.parse(parts[0].trim());
                            String scope = parts[1].trim();
                            AppointmentStatus status = AppointmentStatus.valueOf(parts[2].trim());
                            String patient_email = parts[3].trim();
                            String doctor_email = parts[4].trim();
                            this.appointmentRepository.save(new Appointment(appointmentDate, scope, status, (Doctor)this.doctorRepository.findByEmail(doctor_email).get(), (Patient)this.patientRepository.findByEmail(patient_email).get()));
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void loadDoctortData() {
        if (this.doctorRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/doctors.txt")).getInputStream()))) {
                    while((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            String firstName = parts[0].trim();
                            String lastName = parts[1].trim();
                            String email = parts[2].trim();
                            String medicalDep = parts[3].trim();
                            this.doctorRepository.save(new Doctor(lastName, firstName, email, medicalDep));
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void loadPacientData() {
        if (this.patientRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/pacients.txt")).getInputStream()))) {
                    while((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            String firstName = parts[0].trim();
                            String lastName = parts[1].trim();
                            String email = parts[2].trim();
                            this.patientRepository.save(new Patient(lastName, firstName, email));
                        }
                    }
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void run(String... args) throws Exception {
        this.loadDoctortData();
        this.loadPacientData();
        this.loadAppointmentData();
    }
}
