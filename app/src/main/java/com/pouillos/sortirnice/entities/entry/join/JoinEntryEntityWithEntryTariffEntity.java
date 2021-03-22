package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryTariffEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryTariffEntityId;

    @Generated(hash = 1868671004)
    public JoinEntryEntityWithEntryTariffEntity(Long id, Long entryEntityId,
            Long entryTariffEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryTariffEntityId = entryTariffEntityId;
    }

    @Generated(hash = 1178711464)
    public JoinEntryEntityWithEntryTariffEntity() {
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

    public Long getEntryTariffEntityId() {
        return this.entryTariffEntityId;
    }

    public void setEntryTariffEntityId(Long entryTariffEntityId) {
        this.entryTariffEntityId = entryTariffEntityId;
    }

}
