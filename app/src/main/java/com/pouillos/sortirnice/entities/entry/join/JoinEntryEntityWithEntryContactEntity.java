package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryContactEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryContactEntityId;

    @Generated(hash = 2084438900)
    public JoinEntryEntityWithEntryContactEntity(Long id, Long entryEntityId,
            Long entryContactEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryContactEntityId = entryContactEntityId;
    }

    @Generated(hash = 510579360)
    public JoinEntryEntityWithEntryContactEntity() {
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

    public Long getEntryContactEntityId() {
        return this.entryContactEntityId;
    }

    public void setEntryContactEntityId(Long entryContactEntityId) {
        this.entryContactEntityId = entryContactEntityId;
    }

}
