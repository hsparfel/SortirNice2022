package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryLocationEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryLocationEntityId;

    @Generated(hash = 813616104)
    public JoinEntryEntityWithEntryLocationEntity(Long id, Long entryEntityId,
            Long entryLocationEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryLocationEntityId = entryLocationEntityId;
    }

    @Generated(hash = 1025839539)
    public JoinEntryEntityWithEntryLocationEntity() {
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

    public Long getEntryLocationEntityId() {
        return this.entryLocationEntityId;
    }

    public void setEntryLocationEntityId(Long entryLocationEntityId) {
        this.entryLocationEntityId = entryLocationEntityId;
    }

}
