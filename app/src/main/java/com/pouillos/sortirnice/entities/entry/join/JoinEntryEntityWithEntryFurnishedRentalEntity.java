package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEntryEntityWithEntryFurnishedRentalEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryFurnishedRentalEntityId;

    @Generated(hash = 1656045111)
    public JoinEntryEntityWithEntryFurnishedRentalEntity(Long id,
            Long entryEntityId, Long entryFurnishedRentalEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryFurnishedRentalEntityId = entryFurnishedRentalEntityId;
    }

    @Generated(hash = 1126664046)
    public JoinEntryEntityWithEntryFurnishedRentalEntity() {
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

    public Long getEntryFurnishedRentalEntityId() {
        return this.entryFurnishedRentalEntityId;
    }

    public void setEntryFurnishedRentalEntityId(Long entryFurnishedRentalEntityId) {
        this.entryFurnishedRentalEntityId = entryFurnishedRentalEntityId;
    }





}
