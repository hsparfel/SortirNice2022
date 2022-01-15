package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class EntryRentalMonthEntity extends DetailEntryEntitySimple  {
//public class EntryRentalMonthEntity implements Comparable<EntryRentalMonthEntity> {

    @Id
    private Long id;

    private String value;



    @Generated(hash = 1723777237)
    public EntryRentalMonthEntity(Long id, String value) {
        this.id = id;
        this.value = value;
    }



    @Generated(hash = 471919891)
    public EntryRentalMonthEntity() {
    }



    /*@Override
    public int compareTo(EntryRentalMonthEntity o) {
        return this.getId().compareTo(o.getId());
    }*/



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
