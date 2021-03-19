package com.pouillos.sortirnice.modelevents;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import java.util.List;
import java.util.Map;

@Root
public class Event {

    @Element
    private int id;

    @Element(name="name_fr",required=false)
    private String nameFr;

    @Element(required=false)
    private String start;

    @Element(required=false)
    private String end;

    @Element(required=false)
    private Address address;

    @Element(required=false)
    private String phone;

    @Element(required=false)
    private String email;

    @ElementMap(entry="website", key="type", attribute=true, inline=true, required=false)
    private Map<String, String> WebsiteMap;

    //@ElementList(inline=true, name="profiles")
    //private List<Profile> listProfiles;

    @ElementList(name="profiles", required=false)
    private List<Profile> listProfiles;

    @ElementList(name="stations", required=false)
    private List<Station> listStations;

    //@ElementList(inline=true, name="categories")
   // private List<Category> listCategories;

    //@ElementList(inline=true, name="descriptions")
   // private List<Description> listDescriptions;

    //@ElementList(inline=true, name="images")
   // private List<Image> listImages;

    @ElementList(name="categories", required=false)
    private List<Category> listCategories;

    @ElementList(name="options", required=false)
    private List<Option> listOptions;

    @ElementList(name="sector", required=false)
    private List<Secto> listSectors;

    @ElementList(name="descriptions", required=false)
    private List<Description> listDescriptions;

    @ElementList(name="images", required=false)
    private List<Image> listImages;

    @Element(required=false)
    private double latitude;

    @Element(required=false)
    private double longitude;

    @Element(required=false)
    private int note;

    @Element(name="ref_entries", required=false)
    private RefEntries refEntries;

    @Element(required=false)
    private String created;

    @Element(required=false)
    private String updated;

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getWebsiteMap() {
        return WebsiteMap;
    }

    public void setWebsiteMap(Map<String, String> websiteMap) {
        WebsiteMap = websiteMap;
    }

    public List<Profile> getListProfiles() {
        return listProfiles;
    }

    public void setListProfiles(List<Profile> listProfiles) {
        this.listProfiles = listProfiles;
    }

    public List<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(List<Category> listCategories) {
        this.listCategories = listCategories;
    }

    public List<Description> getListDescriptions() {
        return listDescriptions;
    }

    public void setListDescriptions(List<Description> listDescriptions) {
        this.listDescriptions = listDescriptions;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public void setListImages(List<Image> listImages) {
        this.listImages = listImages;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public RefEntries getRefEntries() {
        return refEntries;
    }

    public void setRefEntries(RefEntries refEntries) {
        this.refEntries = refEntries;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public List<Station> getListStations() {
        return listStations;
    }

    public void setListStations(List<Station> listStations) {
        this.listStations = listStations;
    }

    public List<Option> getListOptions() {
        return listOptions;
    }

    public void setListOptions(List<Option> listOptions) {
        this.listOptions = listOptions;
    }

    public List<Secto> getListSectors() {
        return listSectors;
    }

    public void setListSectors(List<Secto> listSectors) {
        this.listSectors = listSectors;
    }
}
