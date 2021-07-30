package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEntryEntityWithEntrySleepingEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entrySleepingEntityId;

    @Generated(hash = 435553184)
    public JoinEntryEntityWithEntrySleepingEntity(Long id, Long entryEntityId,
            Long entrySleepingEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entrySleepingEntityId = entrySleepingEntityId;
    }

    @Generated(hash = 1568593682)
    public JoinEntryEntityWithEntrySleepingEntity() {
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

    public Long getEntrySleepingEntityId() {
        return this.entrySleepingEntityId;
    }

    public void setEntrySleepingEntityId(Long entrySleepingEntityId) {
        this.entrySleepingEntityId = entrySleepingEntityId;
    }

}
