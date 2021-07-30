package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryPublicationEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryPublicationEntityId;

    @Generated(hash = 834061769)
    public JoinEntryEntityWithEntryPublicationEntity(Long id, Long entryEntityId,
            Long entryPublicationEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryPublicationEntityId = entryPublicationEntityId;
    }

    @Generated(hash = 43898749)
    public JoinEntryEntityWithEntryPublicationEntity() {
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

    public Long getEntryPublicationEntityId() {
        return this.entryPublicationEntityId;
    }

    public void setEntryPublicationEntityId(Long entryPublicationEntityId) {
        this.entryPublicationEntityId = entryPublicationEntityId;
    }

}
