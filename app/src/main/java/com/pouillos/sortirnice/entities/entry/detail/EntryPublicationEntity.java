package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryPublicationEntity implements Comparable<EntryPublicationEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 2035295268)
    public EntryPublicationEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 997015675)
    public EntryPublicationEntity() {
    }

    @Override
    public int compareTo(EntryPublicationEntity o) {
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
