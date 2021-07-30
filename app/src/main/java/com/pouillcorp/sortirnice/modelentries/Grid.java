package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Grid {

    @Element(name = "opening_days", required=false)
    private String openingDays;

    @Element(name = "opening_hours", required=false)
    private String openingHours;

    public String getOpeningDays() {
        return openingDays;
    }

    public String getOpeningHours() {
        return openingHours;
    }
}
