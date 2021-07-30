package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryCategoryEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryCategoryEntityId;

    @Generated(hash = 325411829)
    public JoinEntryEntityWithEntryCategoryEntity(Long id, Long entryEntityId,
            Long entryCategoryEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryCategoryEntityId = entryCategoryEntityId;
    }

    @Generated(hash = 1082037763)
    public JoinEntryEntityWithEntryCategoryEntity() {
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

    public Long getEntryCategoryEntityId() {
        return this.entryCategoryEntityId;
    }

    public void setEntryCategoryEntityId(Long entryCategoryEntityId) {
        this.entryCategoryEntityId = entryCategoryEntityId;
    }

}
