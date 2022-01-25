package com.pouillcorp.sortirnice.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DateMaj {

    @Id
    private Long id;

    private String dateMajEntry;

    @Generated(hash = 964289981)
    public DateMaj(Long id, String dateMajEntry) {
        this.id = id;
        this.dateMajEntry = dateMajEntry;
    }

    @Generated(hash = 1172016040)
    public DateMaj() {
    }

    public String getDateMajEntry() {
        return dateMajEntry;
    }

    public void setDateMajEntry(String dateMajEntry) {
        this.dateMajEntry = dateMajEntry;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
