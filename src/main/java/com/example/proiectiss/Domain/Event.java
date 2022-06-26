package com.example.proiectiss.Domain;

public class Event extends Entity<Long> {
    private String nume;
    private String descriere;
    private Integer locuri;

    public Event(String nume, String descriere, Integer locuri) {
        this.nume = nume;
        this.descriere = descriere;
        this.locuri = locuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Integer getLocuri() {
        return locuri;
    }

    public void setLocuri(Integer locuri) {
        this.locuri = locuri;
    }
}



