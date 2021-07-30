package com.pouillcorp.sortirnice.entities.entry.detail;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryImageEntity implements Comparable<EntryImageEntity> {

    @Id
    private Long id;

    private String url;

    @Generated(hash = 660910958)
    public EntryImageEntity(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    @Generated(hash = 777462350)
    public EntryImageEntity() {
    }

    @Override
    public int compareTo(EntryImageEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
