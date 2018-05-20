package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Kunde {

    private String username;
    private String password;
    private String roles;

    private int kundeid;
    private String fornavn;
    private String efternavn;
    private String email;
    private int tlfNr;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oprettelsesDato;

    private String adresse;
    private int zipKode;
    private String city;
    private  String land;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Kunde(){
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getKundeid() {
        return kundeid;
    }

    public void setKundeid(int kundeid) {
        this.kundeid = kundeid;
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

    public int getZipKode() {
        return zipKode;
    }

    public void setZipKode(int zipKode) {
        this.zipKode = zipKode;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
