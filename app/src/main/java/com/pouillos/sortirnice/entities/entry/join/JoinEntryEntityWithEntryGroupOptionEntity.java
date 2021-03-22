package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryGroupOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryGroupOptionEntityId;

    @Generated(hash = 696598166)
    public JoinEntryEntityWithEntryGroupOptionEntity(Long id, Long entryEntityId,
            Long entryGroupOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryGroupOptionEntityId = entryGroupOptionEntityId;
    }

    @Generated(hash = 986237560)
    public JoinEntryEntityWithEntryGroupOptionEntity() {
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

    public Long getEntryGroupOptionEntityId() {
        return this.entryGroupOptionEntityId;
    }

    public void setEntryGroupOptionEntityId(Long entryGroupOptionEntityId) {
        this.entryGroupOptionEntityId = entryGroupOptionEntityId;
    }

}
