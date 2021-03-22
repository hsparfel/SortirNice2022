package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryCategoryEntity implements Comparable<EntryCategoryEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1203642527)
    public EntryCategoryEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 194938441)
    public EntryCategoryEntity() {
    }

    @Override
    public int compareTo(EntryCategoryEntity o) {
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
