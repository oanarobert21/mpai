package com.examen.echipamente.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inchirieri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private InchirieriStatus inchirieriStatus;
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "echipament_id"
    )
    private Echipament echipament;
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id"
    )
    private User user;

    public Inchirieri() {
    }

    public Inchirieri(Long id, LocalDate startDate, LocalDate endDate, InchirieriStatus inchirieriStatus, Echipament echipament, User user) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inchirieriStatus = inchirieriStatus;
        this.echipament = echipament;
        this.user = user;
    }

    public Inchirieri(LocalDate startDate, LocalDate endDate, InchirieriStatus inchirieriStatus, Echipament echipament, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.inchirieriStatus = inchirieriStatus;
        this.echipament = echipament;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public InchirieriStatus getInchirieriStatus() {
        return inchirieriStatus;
    }

    public void setInchirieriStatus(InchirieriStatus inchirieriStatus) {
        this.inchirieriStatus = inchirieriStatus;
    }

    public Echipament getEchipament() {
        return echipament;
    }

    public void setEchipament(Echipament echipament) {
        this.echipament = echipament;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
