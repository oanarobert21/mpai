package com.examen.echipamente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Echipament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String descriere;
    @Column(nullable = false)
    private Boolean valabil;

    public Echipament() {
    }

    public Echipament(Long id, String name, String descriere, Boolean valabil) {
        this.id = id;
        this.name = name;
        this.descriere = descriere;
        this.valabil = valabil;
    }

    public Echipament(String name, String descriere, Boolean valabil) {
        this.name = name;
        this.descriere = descriere;
        this.valabil = valabil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Boolean getValabil() {
        return valabil;
    }

    public void setValabil(Boolean valabil) {
        this.valabil = valabil;
    }
}
