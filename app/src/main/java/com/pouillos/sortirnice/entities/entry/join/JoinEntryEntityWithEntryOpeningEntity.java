package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryOpeningEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryOpeningEntityId;

    @Generated(hash = 605100455)
    public JoinEntryEntityWithEntryOpeningEntity(Long id, Long entryEntityId,
            Long entryOpeningEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryOpeningEntityId = entryOpeningEntityId;
    }

    @Generated(hash = 1735256010)
    public JoinEntryEntityWithEntryOpeningEntity() {
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

    public Long getEntryOpeningEntityId() {
        return this.entryOpeningEntityId;
    }

    public void setEntryOpeningEntityId(Long entryOpeningEntityId) {
        this.entryOpeningEntityId = entryOpeningEntityId;
    }

}
