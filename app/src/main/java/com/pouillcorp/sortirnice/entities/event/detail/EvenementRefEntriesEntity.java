package com.pouillcorp.sortirnice.entities.event.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EvenementRefEntriesEntity implements Comparable<EvenementRefEntriesEntity> {

    @Id
    private Long id;

    private String refEntryId;

    private String refEntryName;


    @Generated(hash = 1631904559)
    public EvenementRefEntriesEntity(Long id, String refEntryId, String refEntryName) {
        this.id = id;
        this.refEntryId = refEntryId;
        this.refEntryName = refEntryName;
    }

    @Generated(hash = 1287117150)
    public EvenementRefEntriesEntity() {
    }


    @Override
    public int compareTo(EvenementRefEntriesEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefEntryId() {
        return refEntryId;
    }

    public void setRefEntryId(String refEntryId) {
        this.refEntryId = refEntryId;
    }

    public String getRefEntryName() {
        return refEntryName;
    }

    public void setRefEntryName(String refEntryName) {
        this.refEntryName = refEntryName;
    }
}
