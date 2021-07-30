package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryAffiliationEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryAffiliationEntityId;

    @Generated(hash = 1412733199)
    public JoinEntryEntityWithEntryAffiliationEntity(Long id, Long entryEntityId,
            Long entryAffiliationEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryAffiliationEntityId = entryAffiliationEntityId;
    }

    @Generated(hash = 1068500027)
    public JoinEntryEntityWithEntryAffiliationEntity() {
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

    public Long getEntryAffiliationEntityId() {
        return this.entryAffiliationEntityId;
    }

    public void setEntryAffiliationEntityId(Long entryAffiliationEntityId) {
        this.entryAffiliationEntityId = entryAffiliationEntityId;
    }

}
