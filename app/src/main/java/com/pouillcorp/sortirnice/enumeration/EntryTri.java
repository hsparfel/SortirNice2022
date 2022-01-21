package com.pouillcorp.sortirnice.enumeration;

public enum EntryTri {
    //Objets directement construits
    Nom("name_fr","Nom");

    private String name = "";
    private String nom = "";

    //Constructeur
    EntryTri(String name, String nom){
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
