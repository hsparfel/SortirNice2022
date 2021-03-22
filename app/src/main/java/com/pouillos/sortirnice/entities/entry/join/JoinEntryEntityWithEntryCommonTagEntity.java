package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryCommonTagEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryCommonTagEntityId;

    @Generated(hash = 1764573592)
    public JoinEntryEntityWithEntryCommonTagEntity(Long id, Long entryEntityId,
            Long entryCommonTagEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryCommonTagEntityId = entryCommonTagEntityId;
    }

    @Generated(hash = 1643598420)
    public JoinEntryEntityWithEntryCommonTagEntity() {
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

    public Long getEntryCommonTagEntityId() {
        return this.entryCommonTagEntityId;
    }

    public void setEntryCommonTagEntityId(Long entryCommonTagEntityId) {
        this.entryCommonTagEntityId = entryCommonTagEntityId;
    }

}
