package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntrySectorEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entrySectorEntityId;

    @Generated(hash = 439642425)
    public JoinEntryEntityWithEntrySectorEntity(Long id, Long entryEntityId,
            Long entrySectorEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entrySectorEntityId = entrySectorEntityId;
    }

    @Generated(hash = 1585775611)
    public JoinEntryEntityWithEntrySectorEntity() {
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

    public Long getEntrySectorEntityId() {
        return this.entrySectorEntityId;
    }

    public void setEntrySectorEntityId(Long entrySectorEntityId) {
        this.entrySectorEntityId = entrySectorEntityId;
    }

}
