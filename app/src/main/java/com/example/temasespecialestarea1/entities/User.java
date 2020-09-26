package com.example.temasespecialestarea1.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String first_name;
    private String last_name;
    private String gender;
    private String born;
    private boolean likesProgramming;
    private ArrayList<String> languages;

    public User(String first_name, String last_name, String gender, String born, boolean likesProgramming, ArrayList<String> languages) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.born = born;
        this.likesProgramming = likesProgramming;
        this.languages = languages;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public boolean isLikesProgramming() {
        return likesProgramming;
    }

    public void setLikesProgramming(boolean likesProgramming) {
        this.likesProgramming = likesProgramming;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        String name_introduction = "Hola! mi nombre es: " + getFirst_name() + " " + getLast_name();
        String gender_date = "Soy " + getGender() + ", y naci en fecha " + getBorn() + ".";
        String programming = isLikesProgramming() ? "Me gusta programar. Mis lenguajes favoritos son: " + getLanguages().toString().replace("[", "").replace("]", "") :
                "No me gusta programar";
        return name_introduction + "\n\n" + gender_date + "\n\n" + programming;
    }
}
