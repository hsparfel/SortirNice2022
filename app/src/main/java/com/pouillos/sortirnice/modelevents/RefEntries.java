package com.pouillos.sortirnice.modelevents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root
public class RefEntries {
//bug car il peut y en avoir plusieurs
    @Element (name="ref_entry_id", required=false)
    private String refEntryId;

    @Element (name="ref_entry_name", required=false)
    private String refEntryName;

    public String getRefEntryId() {
        return refEntryId;
    }

    public String getRefEntryName() {
        return refEntryName;
    }
}
