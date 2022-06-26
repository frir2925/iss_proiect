package com.example.proiectiss.Service;

import com.example.proiectiss.Domain.Loc;
import com.example.proiectiss.Repository.RepoLoc;

public class LocService {
    private RepoLoc locRepository;

    public LocService(RepoLoc locRepository) {
        this.locRepository = locRepository;
    }

    public void save(Loc loc) {
        locRepository.save(loc);
    }

    public Iterable<Loc> getAll() {
        return locRepository.findAll();
    }

    public Loc findOneByLoc(Long locnr) {
        return locRepository.findOneByLoc(locnr);
    }

    public void update(Long id, Loc elem) {
        locRepository.update(id, elem);
    }


}
