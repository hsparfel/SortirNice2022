package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryTariffEntity implements Comparable<EntryTariffEntity> {

    @Id
    private Long id;

    private String name;

    private int unique;

    private int min;

    private int max;

    private int average;

    private int fixed;


    @Generated(hash = 1239231463)
    public EntryTariffEntity(Long id, String name, int unique, int min, int max,
            int average, int fixed) {
        this.id = id;
        this.name = name;
        this.unique = unique;
        this.min = min;
        this.max = max;
        this.average = average;
        this.fixed = fixed;
    }


    @Generated(hash = 2080966144)
    public EntryTariffEntity() {
    }


    @Override
    public int compareTo(EntryTariffEntity o) {
        return this.getId().compareTo(o.getId());
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getUnique() {
        return this.unique;
    }


    public void setUnique(int unique) {
        this.unique = unique;
    }


    public int getMin() {
        return this.min;
    }


    public void setMin(int min) {
        this.min = min;
    }


    public int getMax() {
        return this.max;
    }


    public void setMax(int max) {
        this.max = max;
    }


    public int getAverage() {
        return this.average;
    }


    public void setAverage(int average) {
        this.average = average;
    }


    public int getFixed() {
        return this.fixed;
    }


    public void setFixed(int fixed) {
        this.fixed = fixed;
    }

}
