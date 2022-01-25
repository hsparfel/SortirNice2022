package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEntryActivites {
    //Objets directement construits
    Autres("Autres");

    private String name = "";

    //Constructeur
    ExclusionEntryActivites(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
