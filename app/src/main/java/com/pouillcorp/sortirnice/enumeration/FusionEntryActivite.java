package com.pouillcorp.sortirnice.enumeration;

public enum FusionEntryActivite {
    //Objets directement construits
    ActivitesDePleinAir("Activités de plein air ", "Plus d' activités en plein air");

    private String name = "";
    private String nameBis = "";

    //Constructeur
    FusionEntryActivite(String name, String nameBis){
        this.name = name;
        this.nameBis = nameBis;
    }

    public String toString(){
        return name;
    }

    public String toBis() { return nameBis; }
}
