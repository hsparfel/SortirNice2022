package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEntryEntityWithEntryCommerciaEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryCommerciaEntityId;

    @Generated(hash = 1923910527)
    public JoinEntryEntityWithEntryCommerciaEntity(Long id, Long entryEntityId,
            Long entryCommerciaEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryCommerciaEntityId = entryCommerciaEntityId;
    }

    @Generated(hash = 911617961)
    public JoinEntryEntityWithEntryCommerciaEntity() {
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

    public Long getEntryCommerciaEntityId() {
        return this.entryCommerciaEntityId;
    }

    public void setEntryCommerciaEntityId(Long entryCommerciaEntityId) {
        this.entryCommerciaEntityId = entryCommerciaEntityId;
    }




}
