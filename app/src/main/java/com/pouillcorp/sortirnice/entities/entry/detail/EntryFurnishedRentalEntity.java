package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EntryFurnishedRentalEntity implements Comparable<EntryFurnishedRentalEntity> {

    @Id
    private Long id;

    private String value;


    @Generated(hash = 1121644471)
    public EntryFurnishedRentalEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }


    @Generated(hash = 883119103)
    public EntryFurnishedRentalEntity() {
    }


    @Override
    public int compareTo(EntryFurnishedRentalEntity o) {
        return this.getId().compareTo(o.getId());
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getValue() {
        return this.value;
    }


    public void setValue(String value) {
        this.value = value;
    }




}
