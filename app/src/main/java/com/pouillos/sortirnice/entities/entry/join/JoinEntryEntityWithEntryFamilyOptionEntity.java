package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryFamilyOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryFamilyOptionEntityId;

    @Generated(hash = 1676338592)
    public JoinEntryEntityWithEntryFamilyOptionEntity(Long id, Long entryEntityId,
            Long entryFamilyOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryFamilyOptionEntityId = entryFamilyOptionEntityId;
    }

    @Generated(hash = 1028607362)
    public JoinEntryEntityWithEntryFamilyOptionEntity() {
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

    public Long getEntryFamilyOptionEntityId() {
        return this.entryFamilyOptionEntityId;
    }

    public void setEntryFamilyOptionEntityId(Long entryFamilyOptionEntityId) {
        this.entryFamilyOptionEntityId = entryFamilyOptionEntityId;
    }

}
