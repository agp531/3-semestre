package com.example.exercicio1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CandidatoVaga {

    private String name;
    private LocalDate dataNasc;
    private String idioma;
    private String[] habilities;
    private DateTimeFormatter formatter;

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public CandidatoVaga(){
        formatter =
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals("") || name.length() < 2){
            throw new RuntimeException("o campo nome nao esta devidamente preenchido");
        }
        this.name = name;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public String getDataNascString() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = LocalDate.parse(dataNasc,formatter);
    }

    public String[] getHabilities() {
        return habilities;
    }

    public void setHabilities(String[] habilities) {
        this.habilities = habilities;
    }
}
