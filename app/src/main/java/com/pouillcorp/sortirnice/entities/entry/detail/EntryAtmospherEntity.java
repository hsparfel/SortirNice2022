package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryAtmospherEntity implements Comparable<EntryAtmospherEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 863790320)
    public EntryAtmospherEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 748987150)
    public EntryAtmospherEntity() {
    }

    @Override
    public int compareTo(EntryAtmospherEntity o) {
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
