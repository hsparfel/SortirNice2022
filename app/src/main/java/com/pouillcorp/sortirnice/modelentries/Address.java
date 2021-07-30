package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

    @Element (name="address_line1",required=false)
    private String addressLine1;

    @Element (name="address_line2",required=false)
    private String addressLine2;

    @Element (name="address_line3",required=false)
    private String addressLine3;

    @Element(required=false)
    private String zip;

    @Element(required=false)
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

    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
