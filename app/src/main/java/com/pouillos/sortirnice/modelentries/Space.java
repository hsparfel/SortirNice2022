package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Space {

    @Element(required=false)
    private String name;

    @Element(name="capacity_theater", required=false)
    private int capacityTheater;

    @Element(name="capacity_classroom", required=false)
    private int capacityClassroom;

    @Element(name="capacity_u", required=false)
    private int capacityU;

    @Element(name="capacity_cocktail", required=false)
    private int capacityCocktail;

    @Element(name="capacity_seatedmeal", required=false)
    private int capacitySeatedmeal;

    @Element(name="ceiling_height", required=false)
    private int ceilingHeight;

    @Element(name="is_natural_light", required=false)
    private int isNaturalLight;

    @Element(required=false)
    private int area;

    public String getName() {
        return name;
    }

    public int getCapacityTheater() {
        return capacityTheater;
    }

    public int getCapacityClassroom() {
        return capacityClassroom;
    }

    public int getCapacityU() {
        return capacityU;
    }

    public int getCapacityCocktail() {
        return capacityCocktail;
    }

    public int getCapacitySeatedmeal() {
        return capacitySeatedmeal;
    }

    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public int getIsNaturalLight() {
        return isNaturalLight;
    }

    public int getArea() {
        return area;
    }
}
