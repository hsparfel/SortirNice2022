package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntrySpaceEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entrySpaceEntityId;

    @Generated(hash = 663793908)
    public JoinEntryEntityWithEntrySpaceEntity(Long id, Long entryEntityId,
            Long entrySpaceEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entrySpaceEntityId = entrySpaceEntityId;
    }

    @Generated(hash = 159044931)
    public JoinEntryEntityWithEntrySpaceEntity() {
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

    public Long getEntrySpaceEntityId() {
        return this.entrySpaceEntityId;
    }

    public void setEntrySpaceEntityId(Long entrySpaceEntityId) {
        this.entrySpaceEntityId = entrySpaceEntityId;
    }

}
