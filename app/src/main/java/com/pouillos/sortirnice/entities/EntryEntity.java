package com.pouillos.sortirnice.entities;



import com.pouillos.sortirnice.modelentries.Activity;
import com.pouillos.sortirnice.modelentries.Affiliation;
import com.pouillos.sortirnice.modelentries.Amenity;
import com.pouillos.sortirnice.modelentries.Capacity;
import com.pouillos.sortirnice.modelentries.Category;
import com.pouillos.sortirnice.modelentries.Chain;
import com.pouillos.sortirnice.modelentries.Closing;
import com.pouillos.sortirnice.modelentries.Contact;
import com.pouillos.sortirnice.modelentries.Description;
import com.pouillos.sortirnice.modelentries.DisabledOption;
import com.pouillos.sortirnice.modelentries.FrpOption;
import com.pouillos.sortirnice.modelentries.Image;
import com.pouillos.sortirnice.modelentries.Label;
import com.pouillos.sortirnice.modelentries.Living;
import com.pouillos.sortirnice.modelentries.Location;
import com.pouillos.sortirnice.modelentries.Opening;
import com.pouillos.sortirnice.modelentries.Option;
import com.pouillos.sortirnice.modelentries.Payment;
import com.pouillos.sortirnice.modelentries.PoiOption;
import com.pouillos.sortirnice.modelentries.Profile;
import com.pouillos.sortirnice.modelentries.Publication;
import com.pouillos.sortirnice.modelentries.Service;
import com.pouillos.sortirnice.modelentries.Space;
import com.pouillos.sortirnice.modelentries.StandingLevel;
import com.pouillos.sortirnice.modelentries.Station;
import com.pouillos.sortirnice.modelentries.Tariff;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EntryEntity implements Comparable<EventEntity> {

    @Id
    private Long id;

    private Long sortieId;

    private String nameFr;

    private String nameFrShort;

    private String adress;

    private String zip;

    private String city;

    private String phone;

    private String fax;

    private String email;

    private String website;

    /*private List<Contact> listContacts;

    private List<Payment> listPayments;

    private List<Label> listLabels;

    private List<Amenity> listAmenities;

    private List<Profile> listProfiles;

    private List<Location> listLocations;

    private List<Activity> listActivities;

    private List<Category> listCategories;

    private List<Affiliation> listAffiliations;

    private List<Station> listStations;

    private List<StandingLevel> listStandingLevels;

    private List<Chain> listChains;

    private List<Service> listServices;

    private List<Option> listOptions;

    private List<DisabledOption> listDisabledOptions;

    private List<FrpOption> listFrpOptions;

    private List<PoiOption> listPoiOptions;

    private List<Publication> listPublications;

    private List<Description> listDescriptions;

    private List<Image> listImages;*/

    //private Living living;

    //private List<Tariff> listTariffs;

    //private Capacity capacity;

    /*private List<Space> listSpaces;

    private List<Opening> listOpenings;

    private List<Closing> listClosings;*/

    private double latitude;

    private double longitude;

    private String location_map;

    private String note;

    private String start;

    private boolean niceresAvailability;

    private int niceresId;

    private String created;

    private String updated;

    public EntryEntity() {
    }

    @Generated(hash = 1166042888)
    public EntryEntity(Long id, Long sortieId, String nameFr, String nameFrShort,
            String adress, String zip, String city, String phone, String fax,
            String email, String website, double latitude, double longitude,
            String location_map, String note, String start,
            boolean niceresAvailability, int niceresId, String created,
            String updated) {
        this.id = id;
        this.sortieId = sortieId;
        this.nameFr = nameFr;
        this.nameFrShort = nameFrShort;
        this.adress = adress;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.website = website;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_map = location_map;
        this.note = note;
        this.start = start;
        this.niceresAvailability = niceresAvailability;
        this.niceresId = niceresId;
        this.created = created;
        this.updated = updated;
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

    public Long getSortieId() {
        return this.sortieId;
    }

    public void setSortieId(Long sortieId) {
        this.sortieId = sortieId;
    }

    public String getNameFr() {
        return this.nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getNameFrShort() {
        return this.nameFrShort;
    }

    public void setNameFrShort(String nameFrShort) {
        this.nameFrShort = nameFrShort;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getLocation_map() {
        return this.location_map;
    }

    public void setLocation_map(String location_map) {
        this.location_map = location_map;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public boolean getNiceresAvailability() {
        return this.niceresAvailability;
    }

    public void setNiceresAvailability(boolean niceresAvailability) {
        this.niceresAvailability = niceresAvailability;
    }

    public int getNiceresId() {
        return this.niceresId;
    }

    public void setNiceresId(int niceresId) {
        this.niceresId = niceresId;
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


}
