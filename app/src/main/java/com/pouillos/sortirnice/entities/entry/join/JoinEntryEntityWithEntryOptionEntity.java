package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryOptionEntityId;

    @Generated(hash = 1022891761)
    public JoinEntryEntityWithEntryOptionEntity(Long id, Long entryEntityId,
            Long entryOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryOptionEntityId = entryOptionEntityId;
    }

    @Generated(hash = 1467247246)
    public JoinEntryEntityWithEntryOptionEntity() {
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

    public Long getEntryOptionEntityId() {
        return this.entryOptionEntityId;
    }

    public void setEntryOptionEntityId(Long entryOptionEntityId) {
        this.entryOptionEntityId = entryOptionEntityId;
    }

}
