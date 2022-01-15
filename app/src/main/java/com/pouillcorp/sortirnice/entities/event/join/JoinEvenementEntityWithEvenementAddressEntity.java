package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementAddressEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementAddressEntityId;



    @Generated(hash = 1457861260)
    public JoinEvenementEntityWithEvenementAddressEntity(Long id,
            Long evenementEntityId, Long evenementAddressEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementAddressEntityId = evenementAddressEntityId;
    }

    @Generated(hash = 1205172890)
    public JoinEvenementEntityWithEvenementAddressEntity() {
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

    public Long getEvenementAddressEntityId() {
        return evenementAddressEntityId;
    }

    public void setEvenementAddressEntityId(Long evenementAddressEntityId) {
        this.evenementAddressEntityId = evenementAddressEntityId;
    }
}
