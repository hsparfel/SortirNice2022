package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryClosingEntity implements Comparable<EntryClosingEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 539624519)
    public EntryClosingEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1267395575)
    public EntryClosingEntity() {
    }

    @Override
    public int compareTo(EntryClosingEntity o) {
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
