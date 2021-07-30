package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Contact {

    @Element(required=false)
    private String civility;

    @Element(required=false)
    private String name;

    @Element(required=false)
    private String title;

    @Element(required=false)
    private String function;

    @Element(required=false)
    private String phone;

    @Element(required=false)
    private String email;

    public String getCivility() {
        return civility;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getFunction() {
        return function;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
