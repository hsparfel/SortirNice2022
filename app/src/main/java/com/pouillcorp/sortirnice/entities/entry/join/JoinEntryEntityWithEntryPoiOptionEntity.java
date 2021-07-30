package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryPoiOptionEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryPoiOptionEntityId;

    @Generated(hash = 1518879283)
    public JoinEntryEntityWithEntryPoiOptionEntity(Long id, Long entryEntityId,
            Long entryPoiOptionEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryPoiOptionEntityId = entryPoiOptionEntityId;
    }

    @Generated(hash = 1541320724)
    public JoinEntryEntityWithEntryPoiOptionEntity() {
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

    public Long getEntryPoiOptionEntityId() {
        return this.entryPoiOptionEntityId;
    }

    public void setEntryPoiOptionEntityId(Long entryPoiOptionEntityId) {
        this.entryPoiOptionEntityId = entryPoiOptionEntityId;
    }

}
