package com.pouillos.sortirnice.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

    @Element (name="address_content")
    private String addressContent;

    @Element
    private String zip;

    @Element
    private String city;

    @Attribute
    private String type;

    public String getAddressContent() {
        return addressContent;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }
}
