package com.example.demo.model;

public class ProduktSpec {



    private String størelse;
    private int vægt;
    private int pris;
    private String materiale;
    private String farve;

    public ProduktSpec(){
    }

    public ProduktSpec(int vægt, int pris, String materiale, String farve, String størelse) {
        this.vægt = vægt;
        this.pris = pris;
        this.materiale = materiale;
        this.farve = farve;
        this.størelse = størelse;
    }
    public String getStørelse() {
        return størelse;
    }

    public void setStørelse(String størelse) {
        this.størelse = størelse;
    }

    public int getVægt() {
        return vægt;
    }

    public void setVægt(int vægt) {
        this.vægt = vægt;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }
}
