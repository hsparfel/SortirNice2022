package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryServiceEntity extends DetailEntryEntitySimple  {
//public class EntryServiceEntity implements Comparable<EntryServiceEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 62727538)
    public EntryServiceEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1104042980)
    public EntryServiceEntity() {
    }

    /*@Override
    public int compareTo(EntryServiceEntity o) {
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
