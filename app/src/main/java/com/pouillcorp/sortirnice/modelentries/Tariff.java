package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Tariff {

    @Element(required=false)
    private String name;

    @Element(required=false)
    private int unique;

    @Element(required=false)
    private int min;

    @Element(required=false)
    private int max;

    @Element(required=false)
    private int average;

    @Element(required=false)
    private int fixed;

    public String getName() {
        return name;
    }

    public int getUnique() {
        return unique;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getAverage() {
        return average;
    }

    public int getFixed() {
        return fixed;
    }
}
