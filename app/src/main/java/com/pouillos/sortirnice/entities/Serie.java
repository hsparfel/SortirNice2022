package com.pouillos.sortirnice.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Serie implements Comparable<Serie> {

    @Id
    private Long id;

    @NotNull
    private String nom;

    private boolean fini;

    @Generated(hash = 553532319)
    public Serie(Long id, @NotNull String nom, boolean fini) {
        this.id = id;
        this.nom = nom;
        this.fini = fini;
    }

    @Generated(hash = 1219348851)
    public Serie() {
    }

    @Override
    public int compareTo(Serie o) {
        return this.getNom().compareTo(o.getNom());
    }

    @Override
    public String toString() {
        return nom;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getFini() {
        return this.fini;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

}
