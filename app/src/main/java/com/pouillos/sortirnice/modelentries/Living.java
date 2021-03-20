package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Living {

    @Element(name="room_count", required=false)
    private int roomCount;

    @Element(name="room_bath_count", required=false)
    private int roomBathCount;

    @Element(name="room_shower_count", required=false)
    private int roomShowerCount;

    @Element(name="room_nosmoking_count", required=false)
    private int roomNoSmokingCount;

    @Element(name="suite_count", required=false)
    private int suiteCount;

    @Element(name="studio_count", required=false)
    private int studioCount;

    @Element(name="apartment_count", required=false)
    private int apartmentCount;

    @Element(name="room_accessible_count", required=false)
    private int roomAccessibleCount;

    @Element(name="single_count", required=false)
    private int singleCount;

    @Element(name="double_count", required=false)
    private int doubleCount;

    @Element(name="triple_count", required=false)
    private int tripleCount;

    @Element(name="twins_count", required=false)
    private int twinsCount;

    @Element(name="family_count", required=false)
    private int familyCount;

    @Element(required=false)
    private int area;

    @Element(required=false)
    private String type;

    @Element(required=false)
    private int floor;

    @Element(name="bedroom_count", required=false)
    private int bedroomCount;

    @Element(name="sleeps_count", required=false)
    private int sleepsCount;

    @Element(name="furnished_room_count", required=false)
    private int furnishedRoomCount;

    public int getRoomCount() {
        return roomCount;
    }

    public int getRoomBathCount() {
        return roomBathCount;
    }

    public int getRoomShowerCount() {
        return roomShowerCount;
    }

    public int getRoomNoSmokingCount() {
        return roomNoSmokingCount;
    }

    public int getSuiteCount() {
        return suiteCount;
    }

    public int getStudioCount() {
        return studioCount;
    }

    public int getApartmentCount() {
        return apartmentCount;
    }

    public int getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    public int getBedroomCount() {
        return bedroomCount;
    }

    public int getSleepsCount() {
        return sleepsCount;
    }

    public int getFurnishedRoomCount() {
        return furnishedRoomCount;
    }
}
