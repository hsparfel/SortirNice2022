package com.pouillcorp.sortirnice.enumeration;

public enum Entity {
    //Objets directement construits
    Entry("Entry"),
    Evenement ("Evenement");

    private String name = "";

    //Constructeur
    Entity(String name){
        this.name = name;

    }

    public String toString(){
        return name;
    }



}
