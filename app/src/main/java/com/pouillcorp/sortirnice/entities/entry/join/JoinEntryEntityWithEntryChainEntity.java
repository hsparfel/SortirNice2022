package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryChainEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryChainEntityId;

    @Generated(hash = 735288289)
    public JoinEntryEntityWithEntryChainEntity(Long id, Long entryEntityId,
            Long entryChainEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryChainEntityId = entryChainEntityId;
    }

    @Generated(hash = 713997954)
    public JoinEntryEntityWithEntryChainEntity() {
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

    public Long getEntryChainEntityId() {
        return this.entryChainEntityId;
    }

    public void setEntryChainEntityId(Long entryChainEntityId) {
        this.entryChainEntityId = entryChainEntityId;
    }

}
