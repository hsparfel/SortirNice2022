package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryLabelEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryLabelEntityId;

    @Generated(hash = 465722021)
    public JoinEntryEntityWithEntryLabelEntity(Long id, Long entryEntityId,
            Long entryLabelEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryLabelEntityId = entryLabelEntityId;
    }

    @Generated(hash = 525649575)
    public JoinEntryEntityWithEntryLabelEntity() {
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

    public Long getEntryLabelEntityId() {
        return this.entryLabelEntityId;
    }

    public void setEntryLabelEntityId(Long entryLabelEntityId) {
        this.entryLabelEntityId = entryLabelEntityId;
    }

}
