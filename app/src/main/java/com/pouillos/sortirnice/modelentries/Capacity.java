package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Capacity {

    @Element(required=false)
    private int total;

    @Element(required=false)
    private int indoor;

    @Element(required=false)
    private int outdoor;

    @Element(required=false)
    private int seated;

    @Element(required=false)
    private int cocktail;

    @Element(required=false)
    private int group;

    @Element(name = "room_count", required=false)
    private int roomCount;

    @Element(name = "disabled_count", required=false)
    private int disabledCount;

    public int getOutdoor() {
        return outdoor;
    }

    public int getSeated() {
        return seated;
    }

    public int getCocktail() {
        return cocktail;
    }

    public int getTotal() {
        return total;
    }

    public int getIndoor() {
        return indoor;
    }

    public int getGroup() {
        return group;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getDisabledCount() {
        return disabledCount;
    }
}
