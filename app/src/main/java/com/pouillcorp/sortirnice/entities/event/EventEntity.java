package com.pouillcorp.sortirnice.entities.event;


import com.pouillcorp.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementSectoEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementSectoEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

@Entity
public class EventEntity implements Comparable<EventEntity> {

    @Id
    private Long id;

    private Long eventId;

    private String nameFr;

    private String start;

    private String end;

    private String adressSituationContent;

    private String adressSituationZip;

    private String adressSituationCity;

    private String adressPrincipalContent;

    private String adressPrincipalZip;

    private String adressPrincipalCity;

    private String phone;

    private String email;

    private String websiteSituation;

    private String websitePrincipal;

    private String profile;

    private String station;

    private String category;

    private String option;

    private String secto;

    private String descriptionSituation;

    private String descriptionHoraires;

    private String descriptionTarification;

    private String descriptionDescription;

    private String image;

    private double latitude;

    private double longitude;

    private int note;

    private String entryId;

    private String entryName;

    private String created;
    
    private String updated;




    private boolean favori;


    @Generated(hash = 1674426062)
    public EventEntity(Long id, Long eventId, String nameFr, String start,
            String end, String adressSituationContent, String adressSituationZip,
            String adressSituationCity, String adressPrincipalContent,
            String adressPrincipalZip, String adressPrincipalCity, String phone,
            String email, String websiteSituation, String websitePrincipal,
            String profile, String station, String category, String option,
            String secto, String descriptionSituation, String descriptionHoraires,
            String descriptionTarification, String descriptionDescription,
            String image, double latitude, double longitude, int note,
            String entryId, String entryName, String created, String updated,
            boolean favori) {
        this.id = id;
        this.eventId = eventId;
        this.nameFr = nameFr;
        this.start = start;
        this.end = end;
        this.adressSituationContent = adressSituationContent;
        this.adressSituationZip = adressSituationZip;
        this.adressSituationCity = adressSituationCity;
        this.adressPrincipalContent = adressPrincipalContent;
        this.adressPrincipalZip = adressPrincipalZip;
        this.adressPrincipalCity = adressPrincipalCity;
        this.phone = phone;
        this.email = email;
        this.websiteSituation = websiteSituation;
        this.websitePrincipal = websitePrincipal;
        this.profile = profile;
        this.station = station;
        this.category = category;
        this.option = option;
        this.secto = secto;
        this.descriptionSituation = descriptionSituation;
        this.descriptionHoraires = descriptionHoraires;
        this.descriptionTarification = descriptionTarification;
        this.descriptionDescription = descriptionDescription;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.note = note;
        this.entryId = entryId;
        this.entryName = entryName;
        this.created = created;
        this.updated = updated;
        this.favori = favori;
    }

    @Generated(hash = 893269617)
    public EventEntity() {
    }


    @Override
    public int compareTo(EventEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getNameFr() {
        return this.nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAdressSituationContent() {
        return this.adressSituationContent;
    }

    public void setAdressSituationContent(String adressSituationContent) {
        this.adressSituationContent = adressSituationContent;
    }

    public String getAdressSituationZip() {
        return this.adressSituationZip;
    }

    public void setAdressSituationZip(String adressSituationZip) {
        this.adressSituationZip = adressSituationZip;
    }

    public String getAdressSituationCity() {
        return this.adressSituationCity;
    }

    public void setAdressSituationCity(String adressSituationCity) {
        this.adressSituationCity = adressSituationCity;
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

    public String getWebsiteSituation() {
        return this.websiteSituation;
    }

    public void setWebsiteSituation(String websiteSituation) {
        this.websiteSituation = websiteSituation;
    }

    public String getWebsitePrincipal() {
        return this.websitePrincipal;
    }

    public void setWebsitePrincipal(String websitePrincipal) {
        this.websitePrincipal = websitePrincipal;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStation() {
        return this.station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getSecto() {
        return this.secto;
    }

    public void setSecto(String secto) {
        this.secto = secto;
    }

    public String getDescriptionSituation() {
        return this.descriptionSituation;
    }

    public void setDescriptionSituation(String descriptionSituation) {
        this.descriptionSituation = descriptionSituation;
    }

    public String getDescriptionHoraires() {
        return this.descriptionHoraires;
    }

    public void setDescriptionHoraires(String descriptionHoraires) {
        this.descriptionHoraires = descriptionHoraires;
    }

    public String getDescriptionTarification() {
        return this.descriptionTarification;
    }

    public void setDescriptionTarification(String descriptionTarification) {
        this.descriptionTarification = descriptionTarification;
    }

    public String getDescriptionDescription() {
        return this.descriptionDescription;
    }

    public void setDescriptionDescription(String descriptionDescription) {
        this.descriptionDescription = descriptionDescription;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getNote() {
        return this.note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getEntryId() {
        return this.entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getEntryName() {
        return this.entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getAdressPrincipalContent() {
        return adressPrincipalContent;
    }

    public void setAdressPrincipalContent(String adressPrincipalContent) {
        this.adressPrincipalContent = adressPrincipalContent;
    }

    public String getAdressPrincipalZip() {
        return adressPrincipalZip;
    }

    public void setAdressPrincipalZip(String adressPrincipalZip) {
        this.adressPrincipalZip = adressPrincipalZip;
    }

    public String getAdressPrincipalCity() {
        return adressPrincipalCity;
    }

    public void setAdressPrincipalCity(String adressPrincipalCity) {
        this.adressPrincipalCity = adressPrincipalCity;
    }

    public boolean isFavori() {
        return favori;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }

    public boolean getFavori() {
        return this.favori;
    }
}
