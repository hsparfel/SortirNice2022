package com.pouillcorp.sortirnice.modelentries;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;


public class DetailEntrySimple implements Comparable<DetailEntrySimple>{

    protected String value;

    protected boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(DetailEntrySimple o) {
        return this.getValue().compareTo(o.getValue());
    }
}
