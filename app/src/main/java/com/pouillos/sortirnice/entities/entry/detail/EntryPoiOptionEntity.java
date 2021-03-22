package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryPoiOptionEntity implements Comparable<EntryPoiOptionEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1970268699)
    public EntryPoiOptionEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 994992652)
    public EntryPoiOptionEntity() {
    }

    @Override
    public int compareTo(EntryPoiOptionEntity o) {
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
