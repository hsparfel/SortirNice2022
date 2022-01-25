package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEntryService {
    //Objets directement construits
    Services("Services");

    private String name = "";

    //Constructeur
    ExclusionEntryService(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
