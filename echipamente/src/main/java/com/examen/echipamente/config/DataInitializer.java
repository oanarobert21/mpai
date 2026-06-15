package com.examen.echipamente.config;

import com.examen.echipamente.model.Echipament;
import com.examen.echipamente.model.Inchirieri;
import com.examen.echipamente.model.InchirieriStatus;
import com.examen.echipamente.model.User;
import com.examen.echipamente.repository.EchipamentRepository;
import com.examen.echipamente.repository.InchirieriRepository;
import com.examen.echipamente.repository.UserRepository;
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
    private EchipamentRepository echipamentRepository;
    private InchirieriRepository inchirieriRepository;
    private UserRepository userRepository;

    public DataInitializer(EchipamentRepository echipamentRepository, InchirieriRepository inchirieriRepository, UserRepository userRepository) {
        this.echipamentRepository = echipamentRepository;
        this.inchirieriRepository = inchirieriRepository;
        this.userRepository = userRepository;
    }

    public void loadInchirieriData() {
        if (this.inchirieriRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/inchirieri.txt")).getInputStream()))) {
                    while ((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            LocalDate startDate = LocalDate.parse(parts[0].trim());
                            LocalDate endDate = LocalDate.parse(parts[1].trim());
                            InchirieriStatus status = InchirieriStatus.valueOf(parts[2].trim());
                            String echipament_name = parts[3].trim();
                            String user_phoneNumber= parts[4].trim();
                            this.inchirieriRepository.save(new Inchirieri(startDate, endDate, status, (Echipament) this.echipamentRepository.findByName(echipament_name).get(), (User) this.userRepository.findByPhoneNumber(user_phoneNumber).get()));
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

    public void loadEchipamentData() {
        if (this.echipamentRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/echipamente.txt")).getInputStream()))) {
                    while ((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            String echipament_name = parts[0].trim();
                            String descriere = parts[1].trim();
                            Boolean valabil = Boolean.parseBoolean(parts[2].trim());
                            this.echipamentRepository.save(new Echipament(echipament_name, descriere, valabil));
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

    public void loadUserData() {
        if (this.userRepository.count() <= 0L) {
            try {
                String linie;
                try (BufferedReader br = new BufferedReader(new InputStreamReader((new ClassPathResource("data/users.txt")).getInputStream()))) {
                    while ((linie = br.readLine()) != null) {
                        if (!linie.isBlank()) {
                            String[] parts = linie.split(";");
                            String lastName = parts[0].trim();
                            String firstName = parts[1].trim();
                            String phoneNumber = parts[2].trim();
                            this.userRepository.save(new User(lastName, firstName, phoneNumber));
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
        this.loadEchipamentData();
        this.loadUserData();
        this.loadInchirieriData();
    }
}
