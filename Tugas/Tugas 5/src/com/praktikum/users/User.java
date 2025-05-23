package com.praktikum.users;

public abstract class User {
    protected String username, password;

    public abstract void displayAppMenu();
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
