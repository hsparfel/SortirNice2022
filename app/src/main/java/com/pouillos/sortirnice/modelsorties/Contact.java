package com.pouillos.sortirnice.modelsorties;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Contact {

    @Element
    private String civility;

    @Element
    private String name;

    @Element
    private String title;

    @Element
    private String function;

    @Element
    private String phone;

    @Element
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
