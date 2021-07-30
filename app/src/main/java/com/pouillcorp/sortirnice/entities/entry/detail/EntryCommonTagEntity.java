package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryCommonTagEntity implements Comparable<EntryCommonTagEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 432290499)
    public EntryCommonTagEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 2051742983)
    public EntryCommonTagEntity() {
    }

    @Override
    public int compareTo(EntryCommonTagEntity o) {
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
