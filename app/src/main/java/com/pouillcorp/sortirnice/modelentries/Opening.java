package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Opening {

    @Element(name = "opening_start", required=false)
    private String openingStart;

    @Element(name = "opening_end", required=false)
    private String openingEnd;

    @Element(name = "opening_replay", required=false)
    private String openingReplay;

    @ElementList(name="grids", required=false)
    private List<Grid> listGrids;

    public String getOpeningStart() {
        return openingStart;
    }

    public String getOpeningEnd() {
        return openingEnd;
    }

    public String getOpeningReplay() {
        return openingReplay;
    }

    public List<Grid> getListGrids() {
        return listGrids;
    }
}
