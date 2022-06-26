package com.example.proiectiss.Service;

import com.example.proiectiss.Domain.Rezervare;
import com.example.proiectiss.Repository.RepoRezervare;

public class RezervareService {
    private RepoRezervare rezervareRepository;

    public RezervareService(RepoRezervare rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }

    public Iterable<Rezervare> getAll() {
        return rezervareRepository.findAll();
    }


    public void save(Rezervare rez) {
        rezervareRepository.save(rez);
    }

    public void delete(Long id) {
        rezervareRepository.delete(id);
    }

    public void update(Long id, Rezervare rez) {
        rezervareRepository.update(id, rez);
    }

    public Rezervare findOneByLocuri(String locuri) {
        return rezervareRepository.findOneByLocuri(locuri);
    }

}
