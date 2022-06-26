package com.example.proiectiss.Repository;

import com.example.proiectiss.Domain.Rezervare;

public interface RepoRezervare extends Repository<Long, Rezervare> {
    public Rezervare findOneByLocuri(String locuri);
}
