package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEventCategorie {
    //Objets directement construits
    MusiquesAutres("Musiques Autres"),
    Divers("Divers");

    private String name = "";

    //Constructeur
    ExclusionEventCategorie(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
