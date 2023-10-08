package com.olavo.finalproject.client;

import com.olavo.finalproject.common.entity.EntityDTO;

import java.time.LocalDate;

public class ClientDTO extends EntityDTO {

    private String user;

    private LocalDate born;

    private int password;

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
