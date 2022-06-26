package com.example.proiectiss.Domain;

public class Rezervare extends Entity<Long> {
    private String nume;
    private String prenume;
    private String locuri;
    private Integer pret;
    private String paid;

    public Rezervare(String nume, String prenume, String locuri, Integer pret, String paid) {
        this.nume = nume;
        this.prenume = prenume;
        this.locuri = locuri;
        this.pret = pret;
        this.paid = paid;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getLocuri() {
        return locuri;
    }

    public void setLocuri(String locuri) {
        this.locuri = locuri;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
