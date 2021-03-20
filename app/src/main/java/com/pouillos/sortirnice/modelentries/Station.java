package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Station {

    @Text
    private String value;

    public String getValue() {
        return value;
    }
}
