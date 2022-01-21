package com.pouillcorp.sortirnice.enumeration;

public enum EntryAdresseDetail {
    //Objets directement construits

    Adresse1("Adresse1"),
    Adresse2("Adresse2"),
    Adresse3("Adresse3"),
    Zip("Zip"),
    Ville("Ville");

    private String name = "";

    //Constructeur
    EntryAdresseDetail(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
