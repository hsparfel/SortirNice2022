package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Category extends DetailEntrySimple{

    @Text
    protected String value;

    @Override
    public String getValue() {
        return value;
    }
}