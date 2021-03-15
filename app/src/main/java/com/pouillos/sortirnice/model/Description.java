package com.pouillos.sortirnice.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root
public class Description {

    @Attribute
    private String language;

    @Attribute
    private String type;

    @Text
    private String value;

    public String getLanguage() {
        return language;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
