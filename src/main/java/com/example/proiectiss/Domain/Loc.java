package com.example.proiectiss.Domain;

public class Loc extends Entity<Long> {
    private Integer loc;
    private Integer loja;
    private Integer rand;
    private String disponibilitate;
    private Integer pret;

    public Loc(Integer loc, Integer loja, Integer rand, String disponibilitate, Integer pret) {
        this.loc = loc;
        this.loja = loja;
        this.rand = rand;
        this.disponibilitate = disponibilitate;
        this.pret = pret;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(String disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public Integer getLoja() {
        return loja;
    }

    public void setLoja(Integer loja) {
        this.loja = loja;
    }

    public Integer getRand() {
        return rand;
    }

    public void setRand(Integer rand) {
        this.rand = rand;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }
}
