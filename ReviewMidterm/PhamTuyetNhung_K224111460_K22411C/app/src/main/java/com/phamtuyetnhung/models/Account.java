package com.phamtuyetnhung.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Account {
    private int id;
    private String username;
    private String password;
    private boolean saveinfor;

    public Account() {
    }

    public Account(int id, String username, String password, boolean saveinfor) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.saveinfor = saveinfor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isSaveinfor() {
        return saveinfor;
    }

    public void setSaveinfor(boolean saveinfor) {
        this.saveinfor = saveinfor;
    }
}
