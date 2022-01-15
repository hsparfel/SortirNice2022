package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryGroupOptionEntity extends DetailEntryEntitySimple  {
//public class EntryGroupOptionEntity implements Comparable<EntryGroupOptionEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1928844974)
    public EntryGroupOptionEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 202729447)
    public EntryGroupOptionEntity() {
    }

   /* @Override
    public int compareTo(EntryGroupOptionEntity o) {
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
