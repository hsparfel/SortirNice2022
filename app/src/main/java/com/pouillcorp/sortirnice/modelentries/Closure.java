package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Closure {

    @Element (name="closure_day",required=false)
    private String closureDay;

    @Element (name="closure_span",required=false)
    private String closureSpan;

    @Element (name="date",required=false)
    private String date;

    public String getClosureDay() {
        return closureDay;
    }

    public String getClosureSpan() {
        return closureSpan;
    }

    public String getDate() {
        return date;
    }
}
