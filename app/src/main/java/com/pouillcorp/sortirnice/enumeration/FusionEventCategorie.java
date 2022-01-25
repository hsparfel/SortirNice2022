package com.pouillcorp.sortirnice.enumeration;

public enum FusionEventCategorie {
    //Objets directement construits
    Salon("Salon", "Salon professionnel");

    private String name = "";
    private String nameBis = "";

    //Constructeur
    FusionEventCategorie(String name, String nameBis){
        this.name = name;
        this.nameBis = nameBis;
    }

    public String toString(){
        return name;
    }

    public String toBis() { return nameBis; }
}
