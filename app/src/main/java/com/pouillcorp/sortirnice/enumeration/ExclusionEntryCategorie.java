package com.pouillcorp.sortirnice.enumeration;

public enum ExclusionEntryCategorie {
    //Objets directement construits
    InfosPratiques("Infos Pratiques"),
    SansCategorie("Sans Catégorie"),
    SortirANice("Sortir à Nice"),
    ToutesLesBoutiques("Toutes Les Boutiques");

    private String name = "";

    //Constructeur
    ExclusionEntryCategorie(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
