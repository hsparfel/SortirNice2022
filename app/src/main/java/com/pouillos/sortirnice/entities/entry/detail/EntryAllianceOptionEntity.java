package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EntryAllianceOptionEntity implements Comparable<EntryAllianceOptionEntity> {

    @Id
    private Long id;

    private String value;


    @Generated(hash = 62193639)
    public EntryAllianceOptionEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }


    @Generated(hash = 1615189557)
    public EntryAllianceOptionEntity() {
    }


    @Override
    public int compareTo(EntryAllianceOptionEntity o) {
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
