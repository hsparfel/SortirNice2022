package com.pouillcorp.sortirnice.entities.event.join;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class JoinEvenementEntityWithEvenementCategoryEntity {

    @Id
    private Long id;

    private Long evenementEntityId;

    private Long evenementCategoryEntityId;


    @Generated(hash = 738708319)
    public JoinEvenementEntityWithEvenementCategoryEntity(Long id,
            Long evenementEntityId, Long evenementCategoryEntityId) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.evenementCategoryEntityId = evenementCategoryEntityId;
    }

    @Generated(hash = 1877398344)
    public JoinEvenementEntityWithEvenementCategoryEntity() {
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

    public Long getEvenementCategoryEntityId() {
        return evenementCategoryEntityId;
    }

    public void setEvenementCategoryEntityId(Long evenementCategoryEntityId) {
        this.evenementCategoryEntityId = evenementCategoryEntityId;
    }
}
