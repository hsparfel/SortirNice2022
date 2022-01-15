package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementProfileEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementProfileEntityId;



    @Generated(hash = 548528256)
    public JoinEvenementEntityWithEvenementProfileEntity(Long id,
            Long evenementEntityId, Long evenementProfileEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementProfileEntityId = evenementProfileEntityId;
    }

    @Generated(hash = 1253775570)
    public JoinEvenementEntityWithEvenementProfileEntity() {
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

    public Long getEvenementProfileEntityId() {
        return evenementProfileEntityId;
    }

    public void setEvenementProfileEntityId(Long evenementProfileEntityId) {
        this.evenementProfileEntityId = evenementProfileEntityId;
    }
}
