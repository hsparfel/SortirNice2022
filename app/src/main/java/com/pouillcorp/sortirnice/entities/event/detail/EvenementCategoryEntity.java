package com.pouillcorp.sortirnice.entities.event.detail;

import com.pouillcorp.sortirnice.entities.entry.detail.DetailEntryEntitySimple;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EvenementCategoryEntity extends DetailEvenementEntitySimple  {

    @Id
    private Long id;

    private String value;

    @Generated(hash = 1877734814)
    public EvenementCategoryEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Generated(hash = 830217144)
    public EvenementCategoryEntity() {
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
