package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryStationEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryStationEntityId;

    @Generated(hash = 1363431224)
    public JoinEntryEntityWithEntryStationEntity(Long id, Long entryEntityId,
            Long entryStationEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryStationEntityId = entryStationEntityId;
    }

    @Generated(hash = 1188677709)
    public JoinEntryEntityWithEntryStationEntity() {
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

    public Long getEntryStationEntityId() {
        return this.entryStationEntityId;
    }

    public void setEntryStationEntityId(Long entryStationEntityId) {
        this.entryStationEntityId = entryStationEntityId;
    }

}
