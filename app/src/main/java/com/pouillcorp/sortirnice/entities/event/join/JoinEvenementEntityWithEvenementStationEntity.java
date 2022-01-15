package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementStationEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementStationEntityId;



    @Generated(hash = 769204403)
    public JoinEvenementEntityWithEvenementStationEntity(Long id,
            Long evenementEntityId, Long evenementStationEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementStationEntityId = evenementStationEntityId;
    }

    @Generated(hash = 1135053052)
    public JoinEvenementEntityWithEvenementStationEntity() {
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

    public Long getEvenementStationEntityId() {
        return evenementStationEntityId;
    }

    public void setEvenementStationEntityId(Long evenementStationEntityId) {
        this.evenementStationEntityId = evenementStationEntityId;
    }
}
