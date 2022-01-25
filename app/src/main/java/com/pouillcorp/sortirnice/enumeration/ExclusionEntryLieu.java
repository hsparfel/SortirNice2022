package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEntryLieu {
    //Objets directement construits
    Metropole("Metropole");

    private String name = "";

    //Constructeur
    ExclusionEntryLieu(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
