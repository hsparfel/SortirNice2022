package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EntryTypeEntity extends DetailEntryEntitySimple  {
//public class EntryCategoryEntity implements Comparable<EntryCategoryEntity> {

    @Id
    private Long id;

    private String value;


    @Generated(hash = 1031686360)
    public EntryTypeEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1418223795)
    public EntryTypeEntity() {
    }


    /*@Override
    public int compareTo(EntryCategoryEntity o) {
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
