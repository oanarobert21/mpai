package com.examen.echipamente.repository;

import com.examen.echipamente.model.Inchirieri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InchirieriRepository extends JpaRepository<Inchirieri, Long> {
}
