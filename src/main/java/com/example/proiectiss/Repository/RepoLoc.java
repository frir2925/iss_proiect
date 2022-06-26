package com.example.proiectiss.Repository;

import com.example.proiectiss.Domain.Loc;

public interface RepoLoc extends Repository<Long, Loc> {

    public Loc findOneByLoc(Long locnr);
}