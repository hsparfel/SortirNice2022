package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryDisabledOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryDisabledOptionEntityId;

    @Generated(hash = 2145870066)
    public JoinEntryEntityWithEntryDisabledOptionEntity(Long id, Long entryEntityId,
            Long entryDisabledOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryDisabledOptionEntityId = entryDisabledOptionEntityId;
    }

    @Generated(hash = 1038875636)
    public JoinEntryEntityWithEntryDisabledOptionEntity() {
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

    public Long getEntryDisabledOptionEntityId() {
        return this.entryDisabledOptionEntityId;
    }

    public void setEntryDisabledOptionEntityId(Long entryDisabledOptionEntityId) {
        this.entryDisabledOptionEntityId = entryDisabledOptionEntityId;
    }

}
