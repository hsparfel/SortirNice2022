package com.pouillcorp.sortirnice.enumeration;

public enum EvenementDescriptionType {
    //Objets directement construits
    Description("Description"),
    Horaires("Horaires"),
    Nom("Nom"),
    Situation("Situation"),
    Tarification("Tarification");

    private String name = "";

    //Constructeur
    EvenementDescriptionType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
