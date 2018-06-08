package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Kunde {

    private int kundeId;
    private String fornavn;
    private String efternavn;
    private String email;
    private int tlfNr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oprettelsesDato;

    private String adresse;



    private int zipcode;
    private String city;
    private  String land;


    public Kunde(){
    }

    public Kunde(String username, String password, String roles, int kundeId, String fornavn, String efternavn, String email, int tlfNr, Date oprettelsesDato, String adresse, int zipcode, String city, String land) {

        this.kundeId = kundeId;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.email = email;
        this.tlfNr = tlfNr;
        this.oprettelsesDato = oprettelsesDato;
        this.adresse = adresse;
        this.zipcode = zipcode;
        this.city = city;
        this.land = land;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(int tlfNr) {
        this.tlfNr = tlfNr;
    }

    public Date getOprettelsesDato() {
        return oprettelsesDato;
    }

    public void setOprettelsesDato(Date oprettelsesDato) {
        this.oprettelsesDato = oprettelsesDato;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
