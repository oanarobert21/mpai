package com.examen.echipamente.repository;

import com.examen.echipamente.model.Echipament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EchipamentRepository extends JpaRepository<Echipament, Long> {
    Optional<Echipament> findByName(String name);
}
