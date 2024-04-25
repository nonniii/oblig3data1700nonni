package com.example.oblig3data1700;

public class Kinobilletter {

    private int id; // Anta at dette er en automatisk generert verdi
    private String film;
    private int antall;
    private String fornavn;
    private String etternavn;
    private String telefonnr;
    private String epost;

    // Tom konstruktør som trengs av JPA/Hibernate
    public Kinobilletter() {
    }

    // Full konstruktør med alle feltene
    public Kinobilletter(int id, String film, int antall, String fornavn, String etternavn, String telefonnr, String epost) {
        this.id = id;
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }

    // Getters og setters for alle feltene
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }


    @Override
    public String toString() {
        return "Kinobilletter{" +
                "id=" + id +
                ", film='" + film + '\'' +
                ", antall=" + antall +
                ", fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", telefonnr='" + telefonnr + '\'' +
                ", epost='" + epost + '\'' +
                '}';
    }
}


