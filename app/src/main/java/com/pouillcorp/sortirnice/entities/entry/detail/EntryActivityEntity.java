package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryActivityEntity extends DetailEntryEntitySimple {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 416012338)
    public EntryActivityEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1439493675)
    public EntryActivityEntity() {
    }

    /*@Override
    public int compareTo(EntryActivityEntity o) {
        return this.getId().compareTo(o.getId());
    }*/

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
