package com.pouillcorp.sortirnice.modelentries;




import com.pouillcorp.sortirnice.enumeration.EntriesType;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Entry implements Comparable<Entry>{

    @Element(name = "ID")
    private int id;

    @Element(name="name_fr",required=false)
    private String nameFr;

    @Element(name="name_fr_short",required=false)
    private String nameFrShort;

    @Element(required=false)
    private Address address;


    @Element(required=false)
    private String phone;

    @Element(required=false)
    private String fax;

    @Element(required=false)
    private String email;

    @Element(required=false)
    private String website;

    @Element(name="website_Reservation", required=false)
    private String websiteReservation;

    @Element(required=false)
    private String facebook;

    @Element(required=false)
    private String twitter;

    @ElementList(name="contacts", required=false)
    private List<Contact> listContacts;

    @ElementList(name="payments", required=false)
    private List<Payment> listPayments;

    @ElementList(name="languages", required=false)
    private List<Language> listLanguages;

    @ElementList(name="labels", required=false)
    private List<Label> listLabels;

    @ElementList(name="amenities", required=false)
    private List<Amenity> listAmenities;

    @ElementList(name="profiles", required=false)
    private List<Profile> listProfiles;

    @ElementList(name="locations", required=false)
    private List<Location> listLocations;

    @ElementList(name="activities", required=false)
    private List<Activity> listActivities;


    @ElementList(name="categories", required=false)
    private List<Category> listCategories;

    @ElementList(name="atmosphere", required=false)
    private List<Atmospher> listAtmosphere;

    @ElementList(name="animations", required=false)
    private List<Animation> listAnimations;

    @ElementList(name="affiliations", required=false)
    private List<Affiliation> listAffiliations;

    @ElementList(name="stations", required=false)
    private List<Station> listStations;

    //pr failure test passer à true
    @ElementList(name="standings_levels", required=false)
    private List<StandingLevel> listStandingLevels;

    @ElementList(name="chains", required=false)
    private List<Chain> listChains;

    @ElementList(name="services", required=false)
    private List<Service> listServices;

    @ElementList(name="options", required=false)
    private List<Option> listOptions;

    @ElementList(name="disabled_options", required=false)
    private List<DisabledOption> listDisabledOptions;

    @ElementList(name="FRP_options", required=false)
    private List<FrpOption> listFrpOptions;

    @ElementList(name="POI_options", required=false)
    private List<PoiOption> listPoiOptions;

    @ElementList(name="publications", required=false)
    private List<Publication> listPublications;

    @ElementList(name="common_tags", required=false)
    private List<CommonTag> listCommonTags;

    @ElementList(name="sectors", required=false)
    private List<Sector> listSectors;

    @ElementList(name="descriptions", required=false)
    private List<Description> listDescriptions;

    @ElementList(name="images", required=false)
    private List<Image> listImages;

    @Element(required=false)
    private Living living;

    @ElementList(name="tariffs", required=false)
    private List<Tariff> listTariffs;

    @ElementList(name="alliance_options", required=false)
    private List<AllianceOption> listAllianceOptions;

    @ElementList(name="furnished_rentals", required=false)
    private List<FurnishedRental> listFurnishedRentals;

    @ElementList(name="rental_monthes", required=false)
    private List<RentalMonth> listRentalMonthes;

    @ElementList(name="sleepings", required=false)
    private List<Sleeping> listSleepings;

    @Element(required=false)
    private Capacity capacity;

    @ElementList(entry="closures", required=false, inline=true)
    private List<Closures> listClosures;

    @ElementList(name="spaces", required=false)
    private List<Space> listSpaces;

    @ElementList(name="openings", required=false)
    private List<Opening> listOpenings;

    @ElementList(name="closings", required=false)
    private List<Closing> listClosings;

    @ElementList(name="group_options", required=false)
    private List<GroupOption> listGroupOptions;

    @ElementList(name="family_options", required=false)
    private List<FamilyOption> listFamilyOptions;

    @Element(required=false)
    private String opening;

    //@Element(required=false)
    //private String commercial;

    @ElementList(name="commercial", required=false)
    private List<Commercia> listCommercial;

    @Element(required=false)
    private String closing;

    @Element(required=false)
    private double latitude;

    @Element(required=false)
    private double longitude;

    @Element(name = "location_map", required=false)
    private String locationMap;

    @Element(required=false)
    private String note;

    @Element(required=false)
    private String start;

    @Element(name ="niceres_availability", required=false)
    private boolean niceresAvailability;

    @Element(name="niceres_id", required=false)
    private int niceresId;

    @Element(required=false)
    private String created;

    @Element(required=false)
    private String updated;

    private EntriesType entryType;

    public Entry() {
    }

    public List<FurnishedRental> getListFurnishedRentals() {
        return listFurnishedRentals;
    }

    public List<Language> getListLanguages() {
        return listLanguages;
    }

    public List<Atmospher> getListAtmosphere() {
        return listAtmosphere;
    }

    public List<Animation> getListAnimations() {
        return listAnimations;
    }

    public List<CommonTag> getListCommonTags() {
        return listCommonTags;
    }

    public List<Sector> getListSectors() {
        return listSectors;
    }

    public List<Closures> getListClosures() {
        return listClosures;
    }

    public List<GroupOption> getListGroupOptions() {
        return listGroupOptions;
    }

    public List<FamilyOption> getListFamilyOptions() {
        return listFamilyOptions;
    }

    public String getOpening() {
        return opening;
    }

    public List<AllianceOption> getListAllianceOptions() {
        return listAllianceOptions;
    }

    public List<RentalMonth> getListRentalMonthes() {
        return listRentalMonthes;
    }

    public List<Sleeping> getListSleepings() {
        return listSleepings;
    }

    public List<Commercia> getListCommercial() {
        return listCommercial;
    }

    public String getClosing() {
        return closing;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getWebsiteReservation() {
        return websiteReservation;
    }

    public int getId() {
        return id;
    }

    public String getNameFr() {
        return nameFr;
    }

    public String getNameFrShort() {
        return nameFrShort;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public List<Contact> getListContacts() {
        return listContacts;
    }

    public List<Payment> getListPayments() {
        return listPayments;
    }

    public List<Label> getListLabels() {
        return listLabels;
    }

    public List<Amenity> getListAmenities() {
        return listAmenities;
    }

    public List<Profile> getListProfiles() {
        return listProfiles;
    }

    public List<Location> getListLocations() {
        return listLocations;
    }

    public List<Activity> getListActivities() {
        return listActivities;
    }

    public List<Category> getListCategories() {
        return listCategories;
    }

    public List<Affiliation> getListAffiliations() {
        return listAffiliations;
    }

    public List<Station> getListStations() {
        return listStations;
    }

    public List<StandingLevel> getListStandingLevels() {
        return listStandingLevels;
    }

    public List<Chain> getListChains() {
        return listChains;
    }

    public List<Service> getListServices() {
        return listServices;
    }

    public List<Option> getListOptions() {
        return listOptions;
    }

    public List<DisabledOption> getListDisabledOptions() {
        return listDisabledOptions;
    }

    public List<FrpOption> getListFrpOptions() {
        return listFrpOptions;
    }

    public List<PoiOption> getListPoiOptions() {
        return listPoiOptions;
    }

    public List<Publication> getListPublications() {
        return listPublications;
    }

    public List<Description> getListDescriptions() {
        return listDescriptions;
    }

    public List<Image> getListImages() {
        return listImages;
    }

    public Living getLiving() {
        return living;
    }

    public List<Tariff> getListTariffs() {
        return listTariffs;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public List<Space> getListSpaces() {
        return listSpaces;
    }

    public List<Opening> getListOpenings() {
        return listOpenings;
    }

    public List<Closing> getListClosings() {
        return listClosings;
    }



    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLocationMap() {
        return locationMap;
    }

    public String getNote() {
        return note;
    }

    public String getStart() {
        return start;
    }

    public boolean isNiceresAvailability() {
        return niceresAvailability;
    }

    public int getNiceresId() {
        return niceresId;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public EntriesType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntriesType entryType) {
        this.entryType = entryType;
    }

    @Override
    public int compareTo(Entry o) {
        return this.getNameFr().compareTo(o.getNameFr());
    }
}
