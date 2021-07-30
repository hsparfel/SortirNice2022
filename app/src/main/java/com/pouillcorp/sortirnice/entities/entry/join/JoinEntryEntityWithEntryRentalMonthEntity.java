package com.pouillcorp.sortirnice.entities.entry.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEntryEntityWithEntryRentalMonthEntity {

    @Id
    private Long id;

    private Long entryEntityId;

    private Long entryRentalMonthEntityId;

    @Generated(hash = 1913123817)
    public JoinEntryEntityWithEntryRentalMonthEntity(Long id, Long entryEntityId,
            Long entryRentalMonthEntityId) {
        this.id = id;
        this.entryEntityId = entryEntityId;
        this.entryRentalMonthEntityId = entryRentalMonthEntityId;
    }

    @Generated(hash = 800752269)
    public JoinEntryEntityWithEntryRentalMonthEntity() {
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

    public Long getEntryRentalMonthEntityId() {
        return this.entryRentalMonthEntityId;
    }

    public void setEntryRentalMonthEntityId(Long entryRentalMonthEntityId) {
        this.entryRentalMonthEntityId = entryRentalMonthEntityId;
    }






}
