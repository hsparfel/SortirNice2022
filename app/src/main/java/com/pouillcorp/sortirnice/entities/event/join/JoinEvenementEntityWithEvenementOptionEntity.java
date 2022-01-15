package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinEvenementEntityWithEvenementOptionEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementOptionEntityId;



    @Generated(hash = 2135162121)
    public JoinEvenementEntityWithEvenementOptionEntity(Long id,
            Long evenementEntityId, Long evenementOptionEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementOptionEntityId = evenementOptionEntityId;
    }

    @Generated(hash = 1317923625)
    public JoinEvenementEntityWithEvenementOptionEntity() {
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

    public Long getEvenementOptionEntityId() {
        return evenementOptionEntityId;
    }

    public void setEvenementOptionEntityId(Long evenementOptionEntityId) {
        this.evenementOptionEntityId = evenementOptionEntityId;
    }
}
