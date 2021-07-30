package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class DisabledOption extends DetailEntrySimple{

    @Text
    private String value;

    @Override
    public String getValue() {
        return value;
    }
}