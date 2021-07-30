package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEntryEntityWithEntryAllianceOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryAllianceOptionEntityId;

    @Generated(hash = 1125020947)
    public JoinEntryEntityWithEntryAllianceOptionEntity(Long id, Long entryEntityId,
            Long entryAllianceOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryAllianceOptionEntityId = entryAllianceOptionEntityId;
    }

    @Generated(hash = 1177478860)
    public JoinEntryEntityWithEntryAllianceOptionEntity() {
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

    public Long getEntryAllianceOptionEntityId() {
        return this.entryAllianceOptionEntityId;
    }

    public void setEntryAllianceOptionEntityId(Long entryAllianceOptionEntityId) {
        this.entryAllianceOptionEntityId = entryAllianceOptionEntityId;
    }



}
