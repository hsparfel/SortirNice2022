package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryServiceEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryServiceEntityId;

    @Generated(hash = 1731409942)
    public JoinEntryEntityWithEntryServiceEntity(Long id, Long entryEntityId,
            Long entryServiceEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryServiceEntityId = entryServiceEntityId;
    }

    @Generated(hash = 91362641)
    public JoinEntryEntityWithEntryServiceEntity() {
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

    public Long getEntryServiceEntityId() {
        return this.entryServiceEntityId;
    }

    public void setEntryServiceEntityId(Long entryServiceEntityId) {
        this.entryServiceEntityId = entryServiceEntityId;
    }

}
