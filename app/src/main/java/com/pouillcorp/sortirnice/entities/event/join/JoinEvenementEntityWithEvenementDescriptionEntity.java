package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementDescriptionEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementDescriptionEntityId;




    @Generated(hash = 776712379)
    public JoinEvenementEntityWithEvenementDescriptionEntity(Long id,
            Long evenementEntityId, Long evenementDescriptionEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementDescriptionEntityId = evenementDescriptionEntityId;
    }

    @Generated(hash = 403429757)
    public JoinEvenementEntityWithEvenementDescriptionEntity() {
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

    public Long getEvenementDescriptionEntityId() {
        return evenementDescriptionEntityId;
    }

    public void setEvenementDescriptionEntityId(Long evenementDescriptionEntityId) {
        this.evenementDescriptionEntityId = evenementDescriptionEntityId;
    }
}
