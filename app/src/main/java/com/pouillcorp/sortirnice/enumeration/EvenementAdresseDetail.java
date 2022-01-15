package com.pouillcorp.sortirnice.enumeration;

public enum EvenementAdresseDetail {
    //Objets directement construits
    Adresse("Adresse"),
    Zip("Zip"),
    Ville("Ville");

    private String name = "";

    //Constructeur
    EvenementAdresseDetail(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
