package com.pouillos.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEntryEntityWithEntryPaymentEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryPaymentEntityId;

    @Generated(hash = 38155531)
    public JoinEntryEntityWithEntryPaymentEntity(Long id, Long entryEntityId,
            Long entryPaymentEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryPaymentEntityId = entryPaymentEntityId;
    }

    @Generated(hash = 1014406985)
    public JoinEntryEntityWithEntryPaymentEntity() {
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

    public Long getEntryPaymentEntityId() {
        return this.entryPaymentEntityId;
    }

    public void setEntryPaymentEntityId(Long entryPaymentEntityId) {
        this.entryPaymentEntityId = entryPaymentEntityId;
    }

}
