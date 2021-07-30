package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Language {

    @Text
    private String value;

    public String getValue() {
        return value;
    }
}
