package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEntryAmenity {
    //Objets directement construits
    Divers("Divers");

    private String name = "";

    //Constructeur
    ExclusionEntryAmenity(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
