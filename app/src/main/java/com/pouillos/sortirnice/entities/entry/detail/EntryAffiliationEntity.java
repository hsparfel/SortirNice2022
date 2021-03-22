package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryAffiliationEntity implements Comparable<EntryAffiliationEntity> {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 581789157)
    public EntryAffiliationEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1464949399)
    public EntryAffiliationEntity() {
    }

    @Override
    public int compareTo(EntryAffiliationEntity o) {
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
