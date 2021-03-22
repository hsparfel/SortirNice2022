package com.pouillos.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryContactEntity implements Comparable<EntryContactEntity> {

    @Id
    private Long id;

    private String civility;

    private String name;

    private String title;

    private String function;

    private String phone;

    private String email;

    @Generated(hash = 1908190039)
    public EntryContactEntity(Long id, String civility, String name, String title,
            String function, String phone, String email) {
        this.id = id;
        this.civility = civility;
        this.name = name;
        this.title = title;
        this.function = function;
        this.phone = phone;
        this.email = email;
    }

    @Generated(hash = 216579329)
    public EntryContactEntity() {
    }

    @Override
    public int compareTo(EntryContactEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCivility() {
        return this.civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
