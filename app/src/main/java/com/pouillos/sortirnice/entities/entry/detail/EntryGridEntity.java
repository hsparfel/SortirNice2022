package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryGridEntity implements Comparable<EntryGridEntity> {

    @Id
    private Long id;

    private String openingDays;

    private String openingHours;

    @Generated(hash = 1042415262)
    public EntryGridEntity(Long id, String openingDays, String openingHours) {
        this.id = id;
        this.openingDays = openingDays;
        this.openingHours = openingHours;
    }

    @Generated(hash = 1773041434)
    public EntryGridEntity() {
    }

    @Override
    public int compareTo(EntryGridEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpeningDays() {
        return this.openingDays;
    }

    public void setOpeningDays(String openingDays) {
        this.openingDays = openingDays;
    }

    public String getOpeningHours() {
        return this.openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

}
