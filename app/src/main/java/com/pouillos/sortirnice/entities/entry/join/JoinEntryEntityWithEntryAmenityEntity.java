package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryAmenityEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryAmenityEntityId;

    @Generated(hash = 62182600)
    public JoinEntryEntityWithEntryAmenityEntity(Long id, Long entryEntityId,
            Long entryAmenityEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryAmenityEntityId = entryAmenityEntityId;
    }

    @Generated(hash = 1480977443)
    public JoinEntryEntityWithEntryAmenityEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntryEntityId() {
        return this.entryEntityId;
    }

    public void setEntryEntityId(Long entryEntityId) {
        this.entryEntityId = entryEntityId;
    }

    public Long getEntryAmenityEntityId() {
        return this.entryAmenityEntityId;
    }

    public void setEntryAmenityEntityId(Long entryAmenityEntityId) {
        this.entryAmenityEntityId = entryAmenityEntityId;
    }

}
