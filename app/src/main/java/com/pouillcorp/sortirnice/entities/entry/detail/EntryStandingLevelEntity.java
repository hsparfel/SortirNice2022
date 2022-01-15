package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryStandingLevelEntity extends DetailEntryEntitySimple  {
//public class EntryStandingLevelEntity implements Comparable<EntryStandingLevelEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 757997386)
    public EntryStandingLevelEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 839196648)
    public EntryStandingLevelEntity() {
    }

    /*@Override
    public int compareTo(EntryStandingLevelEntity o) {
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
