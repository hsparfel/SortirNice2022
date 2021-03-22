package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryDescriptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryDescriptionEntityId;

    @Generated(hash = 311157728)
    public JoinEntryEntityWithEntryDescriptionEntity(Long id, Long entryEntityId,
            Long entryDescriptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryDescriptionEntityId = entryDescriptionEntityId;
    }

    @Generated(hash = 1673644202)
    public JoinEntryEntityWithEntryDescriptionEntity() {
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

    public Long getEntryDescriptionEntityId() {
        return this.entryDescriptionEntityId;
    }

    public void setEntryDescriptionEntityId(Long entryDescriptionEntityId) {
        this.entryDescriptionEntityId = entryDescriptionEntityId;
    }

}
