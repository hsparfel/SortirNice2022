package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryActivityEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryActivityEntityId;

    @Generated(hash = 428958613)
    public JoinEntryEntityWithEntryActivityEntity(Long id, Long entryEntityId,
            Long entryActivityEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryActivityEntityId = entryActivityEntityId;
    }

    @Generated(hash = 1351722333)
    public JoinEntryEntityWithEntryActivityEntity() {
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

    public Long getEntryActivityEntityId() {
        return this.entryActivityEntityId;
    }

    public void setEntryActivityEntityId(Long entryActivityEntityId) {
        this.entryActivityEntityId = entryActivityEntityId;
    }

}
