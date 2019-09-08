package it.namron.soccerbook.extra;

import java.io.Serializable;

public class Persona implements Serializable {

    public String password;
    public String email;

    public Persona()
    {
        this.password="";
        this.email="";

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}