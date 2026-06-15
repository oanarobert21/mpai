package com.examen.echipamente.dto;

import com.examen.echipamente.model.InchirieriStatus;

import java.time.LocalDate;

public class InchirieriResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String inchirieriStatus;
    private String userFirstName;
    private String userLastName;
    private String echipamentName;
    private String descriereEchipament;

    public InchirieriResponse(Long id, LocalDate startDate, LocalDate endDate, String inchirieriStatus, String userFirstName, String userLastName, String echipamentName, String descriereEchipament) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.inchirieriStatus = inchirieriStatus;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.echipamentName = echipamentName;
        this.descriereEchipament = descriereEchipament;
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

    public String getInchirieriStatus() {
        return inchirieriStatus;
    }

    public void setInchirieriStatus(String inchirieriStatus) {
        this.inchirieriStatus = inchirieriStatus;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEchipamentName() {
        return echipamentName;
    }

    public void setEchipamentName(String echipamentName) {
        this.echipamentName = echipamentName;
    }

    public String getDescriereEchipament() {
        return descriereEchipament;
    }

    public void setDescriereEchipament(String descriereEchipament) {
        this.descriereEchipament = descriereEchipament;
    }
}
