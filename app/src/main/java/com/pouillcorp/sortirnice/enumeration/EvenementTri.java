package com.pouillcorp.sortirnice.enumeration;

public enum EvenementTri {
    //Objets directement construits
    Nom("name_fr","Nom"),
    Date("start","Date");

    private String name = "";
    private String nom = "";

    //Constructeur
    EvenementTri(String name, String nom){
        this.name = name;
        this.nom = nom;
    }

    public String toString(){
        return name;
    }

    public String getNom() {
        return nom;
    }

}
