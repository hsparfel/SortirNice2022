package com.pouillcorp.sortirnice.modelevents;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

    @Element (name="address_content", required=false)
    private String addressContent;

    @Element(required=false)
    private String zip;

    @Element(required=false)
    private String city;

    @Attribute(required=false)
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
