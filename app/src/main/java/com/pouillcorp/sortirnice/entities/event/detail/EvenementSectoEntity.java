package com.pouillcorp.sortirnice.entities.event.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EvenementSectoEntity extends DetailEvenementEntitySimple  {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 258094813)
    public EvenementSectoEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 2099177227)
    public EvenementSectoEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
