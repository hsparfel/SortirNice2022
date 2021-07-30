package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryFrpOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryFrpOptionEntityId;

    @Generated(hash = 1611403048)
    public JoinEntryEntityWithEntryFrpOptionEntity(Long id, Long entryEntityId,
            Long entryFrpOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryFrpOptionEntityId = entryFrpOptionEntityId;
    }

    @Generated(hash = 1276989770)
    public JoinEntryEntityWithEntryFrpOptionEntity() {
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

    public Long getEntryFrpOptionEntityId() {
        return this.entryFrpOptionEntityId;
    }

    public void setEntryFrpOptionEntityId(Long entryFrpOptionEntityId) {
        this.entryFrpOptionEntityId = entryFrpOptionEntityId;
    }

}
