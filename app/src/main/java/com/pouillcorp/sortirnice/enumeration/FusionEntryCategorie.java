package com.pouillcorp.sortirnice.enumeration;

public enum FusionEntryCategorie {
    //Objets directement construits
    Sport("Sport", "Sports");

    private String name = "";
    private String nameBis = "";

    //Constructeur
    FusionEntryCategorie(String name, String nameBis){
        this.name = name;
        this.nameBis = nameBis;
    }

    public String toString(){
        return name;
    }

    public String toBis() { return nameBis; }
}
