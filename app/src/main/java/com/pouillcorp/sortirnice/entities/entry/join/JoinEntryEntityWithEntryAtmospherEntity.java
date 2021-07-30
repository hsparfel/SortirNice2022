package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryAtmospherEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryAtmospherEntityId;

    @Generated(hash = 468733213)
    public JoinEntryEntityWithEntryAtmospherEntity(Long id, Long entryEntityId,
            Long entryAtmospherEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryAtmospherEntityId = entryAtmospherEntityId;
    }

    @Generated(hash = 693165508)
    public JoinEntryEntityWithEntryAtmospherEntity() {
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

    public Long getEntryAtmospherEntityId() {
        return this.entryAtmospherEntityId;
    }

    public void setEntryAtmospherEntityId(Long entryAtmospherEntityId) {
        this.entryAtmospherEntityId = entryAtmospherEntityId;
    }

}
