package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryAnimationEntity implements Comparable<EntryAnimationEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1557147377)
    public EntryAnimationEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 721261348)
    public EntryAnimationEntity() {
    }

    @Override
    public int compareTo(EntryAnimationEntity o) {
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
