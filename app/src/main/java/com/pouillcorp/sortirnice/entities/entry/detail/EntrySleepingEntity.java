package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EntrySleepingEntity extends DetailEntryEntitySimple  {
//public class EntrySleepingEntity implements Comparable<EntrySleepingEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1290960349)
    public EntrySleepingEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 2133319033)
    public EntrySleepingEntity() {
    }

    /*@Override
    public int compareTo(EntrySleepingEntity o) {
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
