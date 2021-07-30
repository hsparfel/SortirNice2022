package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryLivingEntity implements Comparable<EntryLivingEntity> {

    @Id
    private Long id;

    private int roomCount;

    private int roomBathCount;

    private int roomShowerCount;

    private int roomNoSmokingCount;

    private int suiteCount;

    private int studioCount;

    private int apartmentCount;

    private int roomAccessibleCount;

    private int singleCount;

    private int doubleCount;

    private int tripleCount;

    private int twinsCount;

    private int familyCount;

    private float area;

    private String type;

    private int floor;

    private int bedroomCount;

    private int sleepsCount;

    private int furnishedRoomCount;



    @Generated(hash = 2067522754)
    public EntryLivingEntity(Long id, int roomCount, int roomBathCount,
            int roomShowerCount, int roomNoSmokingCount, int suiteCount,
            int studioCount, int apartmentCount, int roomAccessibleCount,
            int singleCount, int doubleCount, int tripleCount, int twinsCount,
            int familyCount, float area, String type, int floor, int bedroomCount,
            int sleepsCount, int furnishedRoomCount) {
        this.id = id;
        this.roomCount = roomCount;
        this.roomBathCount = roomBathCount;
        this.roomShowerCount = roomShowerCount;
        this.roomNoSmokingCount = roomNoSmokingCount;
        this.suiteCount = suiteCount;
        this.studioCount = studioCount;
        this.apartmentCount = apartmentCount;
        this.roomAccessibleCount = roomAccessibleCount;
        this.singleCount = singleCount;
        this.doubleCount = doubleCount;
        this.tripleCount = tripleCount;
        this.twinsCount = twinsCount;
        this.familyCount = familyCount;
        this.area = area;
        this.type = type;
        this.floor = floor;
        this.bedroomCount = bedroomCount;
        this.sleepsCount = sleepsCount;
        this.furnishedRoomCount = furnishedRoomCount;
    }



    @Generated(hash = 487873567)
    public EntryLivingEntity() {
    }



    @Override
    public int compareTo(EntryLivingEntity o) {
        return this.getId().compareTo(o.getId());
    }



    public Long getId() {
        return this.id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public int getRoomCount() {
        return this.roomCount;
    }



    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }



    public int getRoomBathCount() {
        return this.roomBathCount;
    }



    public void setRoomBathCount(int roomBathCount) {
        this.roomBathCount = roomBathCount;
    }



    public int getRoomShowerCount() {
        return this.roomShowerCount;
    }



    public void setRoomShowerCount(int roomShowerCount) {
        this.roomShowerCount = roomShowerCount;
    }



    public int getRoomNoSmokingCount() {
        return this.roomNoSmokingCount;
    }



    public void setRoomNoSmokingCount(int roomNoSmokingCount) {
        this.roomNoSmokingCount = roomNoSmokingCount;
    }



    public int getSuiteCount() {
        return this.suiteCount;
    }



    public void setSuiteCount(int suiteCount) {
        this.suiteCount = suiteCount;
    }



    public int getStudioCount() {
        return this.studioCount;
    }



    public void setStudioCount(int studioCount) {
        this.studioCount = studioCount;
    }



    public int getApartmentCount() {
        return this.apartmentCount;
    }



    public void setApartmentCount(int apartmentCount) {
        this.apartmentCount = apartmentCount;
    }



    public int getRoomAccessibleCount() {
        return this.roomAccessibleCount;
    }



    public void setRoomAccessibleCount(int roomAccessibleCount) {
        this.roomAccessibleCount = roomAccessibleCount;
    }



    public int getSingleCount() {
        return this.singleCount;
    }



    public void setSingleCount(int singleCount) {
        this.singleCount = singleCount;
    }



    public int getDoubleCount() {
        return this.doubleCount;
    }



    public void setDoubleCount(int doubleCount) {
        this.doubleCount = doubleCount;
    }



    public int getTripleCount() {
        return this.tripleCount;
    }



    public void setTripleCount(int tripleCount) {
        this.tripleCount = tripleCount;
    }



    public int getTwinsCount() {
        return this.twinsCount;
    }



    public void setTwinsCount(int twinsCount) {
        this.twinsCount = twinsCount;
    }



    public int getFamilyCount() {
        return this.familyCount;
    }



    public void setFamilyCount(int familyCount) {
        this.familyCount = familyCount;
    }



    public float getArea() {
        return this.area;
    }



    public void setArea(float area) {
        this.area = area;
    }



    public String getType() {
        return this.type;
    }



    public void setType(String type) {
        this.type = type;
    }



    public int getFloor() {
        return this.floor;
    }



    public void setFloor(int floor) {
        this.floor = floor;
    }



    public int getBedroomCount() {
        return this.bedroomCount;
    }



    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }



    public int getSleepsCount() {
        return this.sleepsCount;
    }



    public void setSleepsCount(int sleepsCount) {
        this.sleepsCount = sleepsCount;
    }



    public int getFurnishedRoomCount() {
        return this.furnishedRoomCount;
    }



    public void setFurnishedRoomCount(int furnishedRoomCount) {
        this.furnishedRoomCount = furnishedRoomCount;
    }



}
