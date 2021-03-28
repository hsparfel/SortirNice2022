package com.pouillos.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Commercia {

    @Text
    private String value;

    public String getValue() {
        return value;
    }
}
