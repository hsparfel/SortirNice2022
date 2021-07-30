package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryAmenityEntity implements Comparable<EntryAmenityEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1415805364)
    public EntryAmenityEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1312770052)
    public EntryAmenityEntity() {
    }

    @Override
    public int compareTo(EntryAmenityEntity o) {
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
