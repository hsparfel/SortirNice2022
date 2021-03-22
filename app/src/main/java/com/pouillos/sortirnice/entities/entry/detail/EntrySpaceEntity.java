package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntrySpaceEntity implements Comparable<EntrySpaceEntity> {

    @Id
    private Long id;

    private String name;

    private int capacityTheater;

    private int capacityClassroom;

    private int capacityU;

    private int capacityCocktail;

    private int capacitySeatedmeal;

    private int ceilingHeight;

    private int isNaturalLight;

    private int area;

    @Generated(hash = 1824185907)
    public EntrySpaceEntity(Long id, String name, int capacityTheater,
            int capacityClassroom, int capacityU, int capacityCocktail,
            int capacitySeatedmeal, int ceilingHeight, int isNaturalLight,
            int area) {
        this.id = id;
        this.name = name;
        this.capacityTheater = capacityTheater;
        this.capacityClassroom = capacityClassroom;
        this.capacityU = capacityU;
        this.capacityCocktail = capacityCocktail;
        this.capacitySeatedmeal = capacitySeatedmeal;
        this.ceilingHeight = ceilingHeight;
        this.isNaturalLight = isNaturalLight;
        this.area = area;
    }

    @Generated(hash = 1236563350)
    public EntrySpaceEntity() {
    }

    @Override
    public int compareTo(EntrySpaceEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacityTheater() {
        return this.capacityTheater;
    }

    public void setCapacityTheater(int capacityTheater) {
        this.capacityTheater = capacityTheater;
    }

    public int getCapacityClassroom() {
        return this.capacityClassroom;
    }

    public void setCapacityClassroom(int capacityClassroom) {
        this.capacityClassroom = capacityClassroom;
    }

    public int getCapacityU() {
        return this.capacityU;
    }

    public void setCapacityU(int capacityU) {
        this.capacityU = capacityU;
    }

    public int getCapacityCocktail() {
        return this.capacityCocktail;
    }

    public void setCapacityCocktail(int capacityCocktail) {
        this.capacityCocktail = capacityCocktail;
    }

    public int getCapacitySeatedmeal() {
        return this.capacitySeatedmeal;
    }

    public void setCapacitySeatedmeal(int capacitySeatedmeal) {
        this.capacitySeatedmeal = capacitySeatedmeal;
    }

    public int getCeilingHeight() {
        return this.ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public int getIsNaturalLight() {
        return this.isNaturalLight;
    }

    public void setIsNaturalLight(int isNaturalLight) {
        this.isNaturalLight = isNaturalLight;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

}
