package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Closure {

    @Element (name="closure_day",required=false)
    private String closureDay;

    @Element (name="closure_span",required=false)
    private String closureSpan;



}
