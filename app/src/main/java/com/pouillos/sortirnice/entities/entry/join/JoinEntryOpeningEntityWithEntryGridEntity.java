package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryOpeningEntityWithEntryGridEntity {

    @Id
    private Long id;

    private Long entryOpeningEntityId;

    private Long entryGridEntityId;

    @Generated(hash = 2014873755)
    public JoinEntryOpeningEntityWithEntryGridEntity(Long id,
            Long entryOpeningEntityId, Long entryGridEntityId) {
        this.id = id;
        this.entryOpeningEntityId = entryOpeningEntityId;
        this.entryGridEntityId = entryGridEntityId;
    }

    @Generated(hash = 1207365781)
    public JoinEntryOpeningEntityWithEntryGridEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntryOpeningEntityId() {
        return this.entryOpeningEntityId;
    }

    public void setEntryOpeningEntityId(Long entryOpeningEntityId) {
        this.entryOpeningEntityId = entryOpeningEntityId;
    }

    public Long getEntryGridEntityId() {
        return this.entryGridEntityId;
    }

    public void setEntryGridEntityId(Long entryGridEntityId) {
        this.entryGridEntityId = entryGridEntityId;
    }


}
