package com.pouillcorp.sortirnice.entities.event.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EvenementAddressEntity implements Comparable<EvenementAddressEntity> {

    @Id
    private Long id;

    private String addressContent;

    private String zip;

    private String city;

    private String type;

    private boolean isChecked;



    @Generated(hash = 1297865738)
    public EvenementAddressEntity(Long id, String addressContent, String zip,
            String city, String type, boolean isChecked) {
        this.id = id;
        this.addressContent = addressContent;
        this.zip = zip;
        this.city = city;
        this.type = type;
        this.isChecked = isChecked;
    }

    @Generated(hash = 338857352)
    public EvenementAddressEntity() {
    }



    @Override
    public int compareTo(EvenementAddressEntity o) {
        return this.getCity().compareTo(o.getCity());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressContent() {
        return addressContent;
    }

    public void setAddressContent(String addressContent) {
        this.addressContent = addressContent;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
