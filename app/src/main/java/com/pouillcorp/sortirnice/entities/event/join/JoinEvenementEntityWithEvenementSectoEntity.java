package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementSectoEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementSectoEntityId;



    @Generated(hash = 499797337)
    public JoinEvenementEntityWithEvenementSectoEntity(Long id,
            Long evenementEntityId, Long evenementSectoEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementSectoEntityId = evenementSectoEntityId;
    }

    @Generated(hash = 389229407)
    public JoinEvenementEntityWithEvenementSectoEntity() {
    }



    public Long getId() {
        return id;
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

    public Long getEvenementSectoEntityId() {
        return evenementSectoEntityId;
    }

    public void setEvenementSectoEntityId(Long evenementSectoEntityId) {
        this.evenementSectoEntityId = evenementSectoEntityId;
    }
}
