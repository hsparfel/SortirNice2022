package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryProfileEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryProfileEntityId;

    @Generated(hash = 1505907963)
    public JoinEntryEntityWithEntryProfileEntity(Long id, Long entryEntityId,
            Long entryProfileEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryProfileEntityId = entryProfileEntityId;
    }

    @Generated(hash = 1777481310)
    public JoinEntryEntityWithEntryProfileEntity() {
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

    public Long getEntryProfileEntityId() {
        return this.entryProfileEntityId;
    }

    public void setEntryProfileEntityId(Long entryProfileEntityId) {
        this.entryProfileEntityId = entryProfileEntityId;
    }

}
