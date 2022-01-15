package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEvenementEntityWithEvenementRefEntriesEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementRefEntriesEntityId;





    @Generated(hash = 514165150)
    public JoinEvenementEntityWithEvenementRefEntriesEntity(Long id,
            Long evenementEntityId, Long evenementRefEntriesEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementRefEntriesEntityId = evenementRefEntriesEntityId;
    }

    @Generated(hash = 556737094)
    public JoinEvenementEntityWithEvenementRefEntriesEntity() {
    }





    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvenementEntityId() {
        return evenementEntityId;
    }

    public void setEvenementEntityId(Long evenementEntityId) {
        this.evenementEntityId = evenementEntityId;
    }

    public Long getEvenementRefEntriesEntityId() {
        return evenementRefEntriesEntityId;
    }

    public void setEvenementRefEntriesEntityId(Long evenementRefEntriesEntityId) {
        this.evenementRefEntriesEntityId = evenementRefEntriesEntityId;
    }
}
