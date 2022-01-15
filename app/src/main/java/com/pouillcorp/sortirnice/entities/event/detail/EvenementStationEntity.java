package com.pouillcorp.sortirnice.entities.event.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EvenementStationEntity extends DetailEvenementEntitySimple  {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1644423706)
    public EvenementStationEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 1369153350)
    public EvenementStationEntity() {
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
