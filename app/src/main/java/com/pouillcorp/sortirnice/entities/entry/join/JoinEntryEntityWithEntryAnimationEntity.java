package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryAnimationEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryAnimationEntityId;

    @Generated(hash = 295163240)
    public JoinEntryEntityWithEntryAnimationEntity(Long id, Long entryEntityId,
            Long entryAnimationEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryAnimationEntityId = entryAnimationEntityId;
    }

    @Generated(hash = 925823894)
    public JoinEntryEntityWithEntryAnimationEntity() {
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

    public Long getEntryAnimationEntityId() {
        return this.entryAnimationEntityId;
    }

    public void setEntryAnimationEntityId(Long entryAnimationEntityId) {
        this.entryAnimationEntityId = entryAnimationEntityId;
    }

}
