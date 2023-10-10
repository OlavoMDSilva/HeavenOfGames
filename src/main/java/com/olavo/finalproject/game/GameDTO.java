package com.olavo.finalproject.game;

import com.olavo.finalproject.common.entity.EntityDTO;

import java.time.LocalDate;

public class GameDTO extends EntityDTO {

    private LocalDate launchedDate;

    private String idiom, platform, genre, company;

    private double price;

    private int codGenre, codCompany;

    public LocalDate getLaunchedDate() {
        return launchedDate;
    }

    public void setLaunchedDate(LocalDate launchedDate) {
        this.launchedDate = launchedDate;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCodGenre() {
        return codGenre;
    }

    public void setCodGenre(int codGenre) {
        this.codGenre = codGenre;
    }

    public int getCodCompany() {
        return codCompany;
    }

    public void setCodCompany(int codCompany) {
        this.codCompany = codCompany;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
