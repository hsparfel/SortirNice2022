package com.pouillcorp.sortirnice.modelevents;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Secto {

    @Text
    private String value;

    public String getValue() {
        return value;
    }
}
