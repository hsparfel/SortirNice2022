package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryStandingLevelEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryStandingLevelEntityId;

    @Generated(hash = 246239477)
    public JoinEntryEntityWithEntryStandingLevelEntity(Long id, Long entryEntityId,
            Long entryStandingLevelEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryStandingLevelEntityId = entryStandingLevelEntityId;
    }

    @Generated(hash = 2054385511)
    public JoinEntryEntityWithEntryStandingLevelEntity() {
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

    public Long getEntryStandingLevelEntityId() {
        return this.entryStandingLevelEntityId;
    }

    public void setEntryStandingLevelEntityId(Long entryStandingLevelEntityId) {
        this.entryStandingLevelEntityId = entryStandingLevelEntityId;
    }

}
