package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryCapacityEntity implements Comparable<EntryCapacityEntity> {

    @Id
    private Long id;

    private int total;

    private int indoor;

    private int outdoor;

    private int seated;

    private int cocktail;

    private int group;

    private int roomCount;

    private int disabledCount;

    @Generated(hash = 1935394238)
    public EntryCapacityEntity(Long id, int total, int indoor, int outdoor,
            int seated, int cocktail, int group, int roomCount, int disabledCount) {
        this.id = id;
        this.total = total;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.seated = seated;
        this.cocktail = cocktail;
        this.group = group;
        this.roomCount = roomCount;
        this.disabledCount = disabledCount;
    }

    @Generated(hash = 1466213043)
    public EntryCapacityEntity() {
    }

    @Override
    public int compareTo(EntryCapacityEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIndoor() {
        return this.indoor;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public int getOutdoor() {
        return this.outdoor;
    }

    public void setOutdoor(int outdoor) {
        this.outdoor = outdoor;
    }

    public int getSeated() {
        return this.seated;
    }

    public void setSeated(int seated) {
        this.seated = seated;
    }

    public int getCocktail() {
        return this.cocktail;
    }

    public void setCocktail(int cocktail) {
        this.cocktail = cocktail;
    }

    public int getGroup() {
        return this.group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getRoomCount() {
        return this.roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getDisabledCount() {
        return this.disabledCount;
    }

    public void setDisabledCount(int disabledCount) {
        this.disabledCount = disabledCount;
    }

}
