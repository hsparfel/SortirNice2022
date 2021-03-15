package com.pouillos.sortirnice.enumeration;

public enum Langage {
    //Objets directement construits
    Fr("Fr"),
    Vost("Vost");

    private String name = "";

    //Constructeur
    Langage(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
