package com.pouillcorp.sortirnice.entities.entry.detail;


public class DetailEntryEntitySimple implements Comparable<DetailEntryEntitySimple>{

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
    public int compareTo(DetailEntryEntitySimple o) {
        return this.getValue().compareTo(o.getValue());
    }
}
