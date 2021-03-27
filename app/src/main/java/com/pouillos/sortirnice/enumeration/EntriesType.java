package com.pouillos.sortirnice.enumeration;

public enum EntriesType {
    //Objets directement construits
    Restaurant("Restaurant"),
    Transport("Transport"),
    Hotel("Hotel"),
    Boutique("Boutique"),
    Hebergement("Hebergement"),
    Visite("Visite"),
    Sortie("Sortie"),
    Shopping("Shopping"),
    Utile("Utile");

    private String name = "";

    //Constructeur
    EntriesType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
