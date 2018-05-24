package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Produkter {


    private int produktId;
    private String produktNavn;
    private int lagerStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDato;
    private Date slutDato;
    private String leveringstid;


    public Produkter(){

    }


    public Produkter(int produktId, String produktNavn, int lagerStatus, Date startDato, Date slutDato, String leveringstid) {
        this.produktId = produktId;
        this.produktNavn = produktNavn;
        this.lagerStatus = lagerStatus;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getLeveringstid() {
        return leveringstid;
    }

    public void setLeveringstid(String leveringstid) {
        this.leveringstid = leveringstid;
    }

    public Date getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(Date slutDato) {
        this.slutDato = slutDato;
    }

    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }

    public String getProduktNavn() {
        return produktNavn;
    }

    public void setProduktNavn(String produktNavn) {
        this.produktNavn = produktNavn;
    }

    public int getLagerStatus() {
        return lagerStatus;
    }

    public void setLagerStatus(int lagerStatus) {
        this.lagerStatus = lagerStatus;
    }

    public Date getStartDato() {
        return startDato;
    }

    public void setStartDato(Date startDato) {
        this.startDato = startDato;
    }
}
