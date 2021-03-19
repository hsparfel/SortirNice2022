package com.pouillos.sortirnice.modelsorties;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

    @Element (name="address_line1")
    private String addressLine1;

    @Element (name="address_line2")
    private String addressLine2;

    @Element (name="address_line3")
    private String addressLine3;

    @Element
    private String zip;

    @Element
    private String city;

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
}
