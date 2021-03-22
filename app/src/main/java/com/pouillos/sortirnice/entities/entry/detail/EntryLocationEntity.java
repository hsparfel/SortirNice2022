package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryLocationEntity implements Comparable<EntryLocationEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 116392927)
    public EntryLocationEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1850819408)
    public EntryLocationEntity() {
    }

    @Override
    public int compareTo(EntryLocationEntity o) {
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
