package com.pouillcorp.sortirnice.entities.event.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EvenementDescriptionEntity implements Comparable<EvenementDescriptionEntity> {

    @Id
    private Long id;

    private String language;

    private String type;

    private String value;

    @Generated(hash = 1670995169)
    public EvenementDescriptionEntity(Long id, String language, String type, String value) {
        this.id = id;
        this.language = language;
        this.type = type;
        this.value = value;
    }

    @Generated(hash = 1211814811)
    public EvenementDescriptionEntity() {
    }

    @Override
    public int compareTo(EvenementDescriptionEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
