package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryLanguageEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryLanguageEntityId;

    @Generated(hash = 2059327723)
    public JoinEntryEntityWithEntryLanguageEntity(Long id, Long entryEntityId,
            Long entryLanguageEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryLanguageEntityId = entryLanguageEntityId;
    }

    @Generated(hash = 1216603714)
    public JoinEntryEntityWithEntryLanguageEntity() {
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

    public Long getEntryLanguageEntityId() {
        return this.entryLanguageEntityId;
    }

    public void setEntryLanguageEntityId(Long entryLanguageEntityId) {
        this.entryLanguageEntityId = entryLanguageEntityId;
    }

}
