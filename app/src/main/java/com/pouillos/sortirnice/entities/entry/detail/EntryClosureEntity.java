package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryClosureEntity implements Comparable<EntryClosureEntity> {

    @Id
    private Long id;

    private String closureDay;

    private String closureSpan;

    private String date;

    @Generated(hash = 1495037074)
    public EntryClosureEntity(Long id, String closureDay, String closureSpan,
            String date) {
        this.id = id;
        this.closureDay = closureDay;
        this.closureSpan = closureSpan;
        this.date = date;
    }

    @Generated(hash = 582055885)
    public EntryClosureEntity() {
    }

    @Override
    public int compareTo(EntryClosureEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClosureDay() {
        return this.closureDay;
    }

    public void setClosureDay(String closureDay) {
        this.closureDay = closureDay;
    }

    public String getClosureSpan() {
        return this.closureSpan;
    }

    public void setClosureSpan(String closureSpan) {
        this.closureSpan = closureSpan;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
