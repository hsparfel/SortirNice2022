package com.pouillcorp.sortirnice.entities.event.detail;


public class DetailEvenementEntitySimple implements Comparable<DetailEvenementEntitySimple>{

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
    public int compareTo(DetailEvenementEntitySimple o) {
        return this.getValue().compareTo(o.getValue());
    }
}
