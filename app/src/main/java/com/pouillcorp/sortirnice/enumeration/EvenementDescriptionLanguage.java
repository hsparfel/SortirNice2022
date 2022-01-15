package com.pouillcorp.sortirnice.enumeration;

public enum EvenementDescriptionLanguage {
    //Objets directement construits
    Fr("fr"),
    En("en");

    private String name = "";

    //Constructeur
    EvenementDescriptionLanguage(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
