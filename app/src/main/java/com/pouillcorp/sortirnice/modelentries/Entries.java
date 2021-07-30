package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Entries {

    @Attribute(name="SchemaLocation", required=false)
    private String schemaLocation;

    @ElementList(inline=true, required=false)
    private List<Entry> listEntries;

    public Entries() {
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public List<Entry> getListEntries() {
        return listEntries;
    }

    public void setListEntries(List<Entry> listEntries) {
        this.listEntries = listEntries;
    }
}
