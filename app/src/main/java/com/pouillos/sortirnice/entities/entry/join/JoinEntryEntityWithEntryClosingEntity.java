package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryClosingEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryClosingEntityId;

    @Generated(hash = 1680222632)
    public JoinEntryEntityWithEntryClosingEntity(Long id, Long entryEntityId,
            Long entryClosingEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryClosingEntityId = entryClosingEntityId;
    }

    @Generated(hash = 1375342229)
    public JoinEntryEntityWithEntryClosingEntity() {
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

    public Long getEntryClosingEntityId() {
        return this.entryClosingEntityId;
    }

    public void setEntryClosingEntityId(Long entryClosingEntityId) {
        this.entryClosingEntityId = entryClosingEntityId;
    }

}
