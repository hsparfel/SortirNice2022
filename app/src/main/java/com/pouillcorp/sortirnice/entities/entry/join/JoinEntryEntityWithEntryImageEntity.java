package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryImageEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryImageEntityId;

    @Generated(hash = 672324491)
    public JoinEntryEntityWithEntryImageEntity(Long id, Long entryEntityId,
            Long entryImageEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryImageEntityId = entryImageEntityId;
    }

    @Generated(hash = 1153257276)
    public JoinEntryEntityWithEntryImageEntity() {
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

    public Long getEntryImageEntityId() {
        return this.entryImageEntityId;
    }

    public void setEntryImageEntityId(Long entryImageEntityId) {
        this.entryImageEntityId = entryImageEntityId;
    }

}
