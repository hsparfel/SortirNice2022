package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryClosureEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryClosureEntityId;

    @Generated(hash = 1239477256)
    public JoinEntryEntityWithEntryClosureEntity(Long id, Long entryEntityId,
            Long entryClosureEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryClosureEntityId = entryClosureEntityId;
    }

    @Generated(hash = 25400799)
    public JoinEntryEntityWithEntryClosureEntity() {
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

    public Long getEntryClosureEntityId() {
        return this.entryClosureEntityId;
    }

    public void setEntryClosureEntityId(Long entryClosureEntityId) {
        this.entryClosureEntityId = entryClosureEntityId;
    }

}
