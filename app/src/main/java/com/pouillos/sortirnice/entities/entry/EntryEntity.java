package com.pouillos.sortirnice.entities.entry;



import com.pouillos.sortirnice.entities.entry.detail.EntryAllianceOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCommerciaEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryFurnishedRentalEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryGroupOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryImageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLivingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPoiOptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryProfileEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryPublicationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryRentalMonthEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySleepingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryStationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAllianceOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommerciaEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFurnishedRentalEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryRentalMonthEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySleepingEntity;
import com.pouillos.sortirnice.entities.event.EventEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryActivityEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAffiliationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryChainEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryContactEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryDisabledOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFamilyOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryFrpOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryGroupOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryImageEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLabelEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLanguageEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryLocationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOpeningEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPaymentEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPoiOptionEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryProfileEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPublicationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySectorEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryServiceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySpaceEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStandingLevelEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryStationEntity;
import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryTariffEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryActivityEntity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.pouillos.sortirnice.dao.DaoSession;
import com.pouillos.sortirnice.dao.EntryFamilyOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryGroupOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryClosingEntityDao;
import com.pouillos.sortirnice.dao.EntryOpeningEntityDao;
import com.pouillos.sortirnice.dao.EntrySpaceEntityDao;
import com.pouillos.sortirnice.dao.EntryClosureEntityDao;
import com.pouillos.sortirnice.dao.EntryTariffEntityDao;
import com.pouillos.sortirnice.dao.EntryImageEntityDao;
import com.pouillos.sortirnice.dao.EntryDescriptionEntityDao;
import com.pouillos.sortirnice.dao.EntrySectorEntityDao;
import com.pouillos.sortirnice.dao.EntryCommonTagEntityDao;
import com.pouillos.sortirnice.dao.EntryPublicationEntityDao;
import com.pouillos.sortirnice.dao.EntryPoiOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryFrpOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryDisabledOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryServiceEntityDao;
import com.pouillos.sortirnice.dao.EntryChainEntityDao;
import com.pouillos.sortirnice.dao.EntryStandingLevelEntityDao;
import com.pouillos.sortirnice.dao.EntryStationEntityDao;
import com.pouillos.sortirnice.dao.EntryAffiliationEntityDao;
import com.pouillos.sortirnice.dao.EntryAnimationEntityDao;
import com.pouillos.sortirnice.dao.EntryAtmospherEntityDao;
import com.pouillos.sortirnice.dao.EntryCategoryEntityDao;
import com.pouillos.sortirnice.dao.EntryActivityEntityDao;
import com.pouillos.sortirnice.dao.EntryLocationEntityDao;
import com.pouillos.sortirnice.dao.EntryProfileEntityDao;
import com.pouillos.sortirnice.dao.EntryAmenityEntityDao;
import com.pouillos.sortirnice.dao.EntryLabelEntityDao;
import com.pouillos.sortirnice.dao.EntryLanguageEntityDao;
import com.pouillos.sortirnice.dao.EntryPaymentEntityDao;
import com.pouillos.sortirnice.dao.EntryContactEntityDao;
import com.pouillos.sortirnice.dao.EntryCapacityEntityDao;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.converter.PropertyConverter;

import com.pouillos.sortirnice.dao.EntryLivingEntityDao;
import com.pouillos.sortirnice.dao.EntryAddressEntityDao;
import com.pouillos.sortirnice.dao.EntryEntityDao;
import com.pouillos.sortirnice.entities.entry.detail.EntryAddressEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAffiliationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAmenityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAnimationEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryAtmospherEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCapacityEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCategoryEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryChainEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosingEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryClosureEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryCommonTagEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryContactEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDescriptionEntity;
import com.pouillos.sortirnice.entities.entry.detail.EntryDisabledOptionEntity;
import com.pouillos.sortirnice.enumeration.EntriesType;
import com.pouillos.sortirnice.dao.EntryAllianceOptionEntityDao;
import com.pouillos.sortirnice.dao.EntryFurnishedRentalEntityDao;
import com.pouillos.sortirnice.dao.EntryRentalMonthEntityDao;
import com.pouillos.sortirnice.dao.EntrySleepingEntityDao;
import com.pouillos.sortirnice.dao.EntryCommerciaEntityDao;

@Entity
public class EntryEntity implements Comparable<EventEntity> {

    @Id
    private Long id;

    private Long entryEntityId;

    @Convert(converter = EntriesTypeConverter.class, columnType = String.class)
    private EntriesType entryType;

    private String nameFr;

    private String nameFrShort;

    private long entryAddressEntityId;
    @ToOne(joinProperty = "entryAddressEntityId")
    private EntryAddressEntity address;

    private String phone;

    private String fax;

    private String email;

    private String website;

    private String websiteReservation;

    private String facebook;

    private String twitter;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryContactEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryContactEntityId")
    private List<EntryContactEntity> listContacts;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryPaymentEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryPaymentEntityId")
    private List<EntryPaymentEntity> listPayments;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryLanguageEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryLanguageEntityId")
    private List<EntryLanguageEntity> listLanguages;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryLabelEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryLabelEntityId")
    private List<EntryLabelEntity> listLabels;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryAmenityEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryAmenityEntityId")
    private List<EntryAmenityEntity> listAmenities;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryProfileEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryProfileEntityId")
    private List<EntryProfileEntity> listProfiles;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryLocationEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryLocationEntityId")
    private List<EntryLocationEntity> listLocations;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryActivityEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryActivityEntityId")
    private List<EntryActivityEntity> listActivities;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryCategoryEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryCategoryEntityId")
    private List<EntryCategoryEntity> listCategories;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryAtmospherEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryAtmospherEntityId")
    private List<EntryAtmospherEntity> listAtmosphere;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryAnimationEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryAnimationEntityId")
    private List<EntryAnimationEntity> listAnimations;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryAffiliationEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryAffiliationEntityId")
    private List<EntryAffiliationEntity> listAffiliations;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryStationEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryStationEntityId")
    private List<EntryStationEntity> listStations;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryStandingLevelEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryStandingLevelEntityId")
    private List<EntryStandingLevelEntity> listStandingLevels;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryChainEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryChainEntityId")
    private List<EntryChainEntity> listChains;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryServiceEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryServiceEntityId")
    private List<EntryServiceEntity> listServices;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryOptionEntityId")
    private List<EntryOptionEntity> listOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryDisabledOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryDisabledOptionEntityId")
    private List<EntryDisabledOptionEntity> listDisabledOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryFrpOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryFrpOptionEntityId")
    private List<EntryFrpOptionEntity> listFrpOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryPoiOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryPoiOptionEntityId")
    private List<EntryPoiOptionEntity> listPoiOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryPublicationEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryPublicationEntityId")
    private List<EntryPublicationEntity> listPublications;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryCommonTagEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryCommonTagEntityId")
    private List<EntryCommonTagEntity> listCommonTags;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntrySectorEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entrySectorEntityId")
    private List<EntrySectorEntity> listSectors;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryDescriptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryDescriptionEntityId")
    private List<EntryDescriptionEntity> listDescriptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryImageEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryImageEntityId")
    private List<EntryImageEntity> listImages;

    private long entryLivingEntityId;
    @ToOne(joinProperty = "entryLivingEntityId")
    private EntryLivingEntity living;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryTariffEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryTariffEntityId")
    private List<EntryTariffEntity> listTariffs;

    private long entryCapacityEntityId;
    @ToOne(joinProperty = "entryCapacityEntityId")
    private EntryCapacityEntity capacity;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryClosureEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryClosureEntityId")
    private List<EntryClosureEntity> listClosures;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryCommerciaEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryCommerciaEntityId")
    private List<EntryCommerciaEntity> listCommercia;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntrySpaceEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entrySpaceEntityId")
    private List<EntrySpaceEntity> listSpaces;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryOpeningEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryOpeningEntityId")
    private List<EntryOpeningEntity> listOpenings;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryClosingEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryClosingEntityId")
    private List<EntryClosingEntity> listClosings;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryGroupOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryGroupOptionEntityId")
    private List<EntryGroupOptionEntity> listGroupOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryFamilyOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryFamilyOptionEntityId")
    private List<EntryFamilyOptionEntity> listFamilyOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryAllianceOptionEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryAllianceOptionEntityId")
    private List<EntryAllianceOptionEntity> listAllianceOptions;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryFurnishedRentalEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryFurnishedRentalEntityId")
    private List<EntryFurnishedRentalEntity> listFurnishedRentals;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntryRentalMonthEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entryRentalMonthEntityId")
    private List<EntryRentalMonthEntity> listRentalMonths;

    @ToMany
    @JoinEntity(entity = JoinEntryEntityWithEntrySleepingEntity.class,
            sourceProperty = "entryEntityId",
            targetProperty = "entrySleepingEntityId")
    private List<EntrySleepingEntity> listSleepings;

    private String opening;

    //private String commercial;

    private String closing;

    private double latitude;

    private double longitude;

    private String location_map;

    private String note;

    private String start;

    private boolean niceresAvailability;

    private int niceresId;

    private String created;

    private String updated;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 767631628)
private transient EntryEntityDao myDao;




@Generated(hash = 1962411818)
public EntryEntity(Long id, Long entryEntityId, EntriesType entryType, String nameFr,
        String nameFrShort, long entryAddressEntityId, String phone, String fax, String email,
        String website, String websiteReservation, String facebook, String twitter,
        long entryLivingEntityId, long entryCapacityEntityId, String opening, String closing,
        double latitude, double longitude, String location_map, String note, String start,
        boolean niceresAvailability, int niceresId, String created, String updated) {
    this.id = id;
    this.entryEntityId = entryEntityId;
    this.entryType = entryType;
    this.nameFr = nameFr;
    this.nameFrShort = nameFrShort;
    this.entryAddressEntityId = entryAddressEntityId;
    this.phone = phone;
    this.fax = fax;
    this.email = email;
    this.website = website;
    this.websiteReservation = websiteReservation;
    this.facebook = facebook;
    this.twitter = twitter;
    this.entryLivingEntityId = entryLivingEntityId;
    this.entryCapacityEntityId = entryCapacityEntityId;
    this.opening = opening;
    this.closing = closing;
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





@Generated(hash = 681417959)
public EntryEntity() {
}





@Generated(hash = 1156467801)
private transient Long address__resolvedKey;

@Generated(hash = 1546035879)
private transient Long living__resolvedKey;

@Generated(hash = 1745046551)
private transient Long capacity__resolvedKey;




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





public Long getEntryEntityId() {
    return this.entryEntityId;
}





public void setEntryEntityId(Long entryEntityId) {
    this.entryEntityId = entryEntityId;
}





public EntriesType getEntryType() {
    return this.entryType;
}





public void setEntryType(EntriesType entryType) {
    this.entryType = entryType;
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





public long getEntryAddressEntityId() {
    return this.entryAddressEntityId;
}





public void setEntryAddressEntityId(long entryAddressEntityId) {
    this.entryAddressEntityId = entryAddressEntityId;
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





public String getWebsiteReservation() {
    return this.websiteReservation;
}





public void setWebsiteReservation(String websiteReservation) {
    this.websiteReservation = websiteReservation;
}





public String getFacebook() {
    return this.facebook;
}





public void setFacebook(String facebook) {
    this.facebook = facebook;
}





public String getTwitter() {
    return this.twitter;
}





public void setTwitter(String twitter) {
    this.twitter = twitter;
}





public long getEntryLivingEntityId() {
    return this.entryLivingEntityId;
}





public void setEntryLivingEntityId(long entryLivingEntityId) {
    this.entryLivingEntityId = entryLivingEntityId;
}





public long getEntryCapacityEntityId() {
    return this.entryCapacityEntityId;
}





public void setEntryCapacityEntityId(long entryCapacityEntityId) {
    this.entryCapacityEntityId = entryCapacityEntityId;
}





public String getOpening() {
    return this.opening;
}





public void setOpening(String opening) {
    this.opening = opening;
}





public String getClosing() {
    return this.closing;
}





public void setClosing(String closing) {
    this.closing = closing;
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





/** To-one relationship, resolved on first access. */
@Generated(hash = 92551804)
public EntryAddressEntity getAddress() {
    long __key = this.entryAddressEntityId;
    if (address__resolvedKey == null || !address__resolvedKey.equals(__key)) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAddressEntityDao targetDao = daoSession.getEntryAddressEntityDao();
        EntryAddressEntity addressNew = targetDao.load(__key);
        synchronized (this) {
            address = addressNew;
            address__resolvedKey = __key;
        }
    }
    return address;
}





/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 2073852951)
public void setAddress(@NotNull EntryAddressEntity address) {
    if (address == null) {
        throw new DaoException(
                "To-one property 'entryAddressEntityId' has not-null constraint; cannot set to-one to null");
    }
    synchronized (this) {
        this.address = address;
        entryAddressEntityId = address.getId();
        address__resolvedKey = entryAddressEntityId;
    }
}





/** To-one relationship, resolved on first access. */
@Generated(hash = 1481372099)
public EntryLivingEntity getLiving() {
    long __key = this.entryLivingEntityId;
    if (living__resolvedKey == null || !living__resolvedKey.equals(__key)) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryLivingEntityDao targetDao = daoSession.getEntryLivingEntityDao();
        EntryLivingEntity livingNew = targetDao.load(__key);
        synchronized (this) {
            living = livingNew;
            living__resolvedKey = __key;
        }
    }
    return living;
}





/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1333870138)
public void setLiving(@NotNull EntryLivingEntity living) {
    if (living == null) {
        throw new DaoException(
                "To-one property 'entryLivingEntityId' has not-null constraint; cannot set to-one to null");
    }
    synchronized (this) {
        this.living = living;
        entryLivingEntityId = living.getId();
        living__resolvedKey = entryLivingEntityId;
    }
}





/** To-one relationship, resolved on first access. */
@Generated(hash = 1365333349)
public EntryCapacityEntity getCapacity() {
    long __key = this.entryCapacityEntityId;
    if (capacity__resolvedKey == null || !capacity__resolvedKey.equals(__key)) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryCapacityEntityDao targetDao = daoSession.getEntryCapacityEntityDao();
        EntryCapacityEntity capacityNew = targetDao.load(__key);
        synchronized (this) {
            capacity = capacityNew;
            capacity__resolvedKey = __key;
        }
    }
    return capacity;
}





/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 270503314)
public void setCapacity(@NotNull EntryCapacityEntity capacity) {
    if (capacity == null) {
        throw new DaoException(
                "To-one property 'entryCapacityEntityId' has not-null constraint; cannot set to-one to null");
    }
    synchronized (this) {
        this.capacity = capacity;
        entryCapacityEntityId = capacity.getId();
        capacity__resolvedKey = entryCapacityEntityId;
    }
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 2045696372)
public List<EntryContactEntity> getListContacts() {
    if (listContacts == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryContactEntityDao targetDao = daoSession.getEntryContactEntityDao();
        List<EntryContactEntity> listContactsNew = targetDao._queryEntryEntity_ListContacts(id);
        synchronized (this) {
            if (listContacts == null) {
                listContacts = listContactsNew;
            }
        }
    }
    return listContacts;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 303154076)
public synchronized void resetListContacts() {
    listContacts = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 77907765)
public List<EntryPaymentEntity> getListPayments() {
    if (listPayments == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryPaymentEntityDao targetDao = daoSession.getEntryPaymentEntityDao();
        List<EntryPaymentEntity> listPaymentsNew = targetDao._queryEntryEntity_ListPayments(id);
        synchronized (this) {
            if (listPayments == null) {
                listPayments = listPaymentsNew;
            }
        }
    }
    return listPayments;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1058174086)
public synchronized void resetListPayments() {
    listPayments = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 454342823)
public List<EntryLanguageEntity> getListLanguages() {
    if (listLanguages == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryLanguageEntityDao targetDao = daoSession.getEntryLanguageEntityDao();
        List<EntryLanguageEntity> listLanguagesNew = targetDao._queryEntryEntity_ListLanguages(id);
        synchronized (this) {
            if (listLanguages == null) {
                listLanguages = listLanguagesNew;
            }
        }
    }
    return listLanguages;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1712906547)
public synchronized void resetListLanguages() {
    listLanguages = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1177320003)
public List<EntryLabelEntity> getListLabels() {
    if (listLabels == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryLabelEntityDao targetDao = daoSession.getEntryLabelEntityDao();
        List<EntryLabelEntity> listLabelsNew = targetDao._queryEntryEntity_ListLabels(id);
        synchronized (this) {
            if (listLabels == null) {
                listLabels = listLabelsNew;
            }
        }
    }
    return listLabels;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1934233956)
public synchronized void resetListLabels() {
    listLabels = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1084131216)
public List<EntryAmenityEntity> getListAmenities() {
    if (listAmenities == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAmenityEntityDao targetDao = daoSession.getEntryAmenityEntityDao();
        List<EntryAmenityEntity> listAmenitiesNew = targetDao._queryEntryEntity_ListAmenities(id);
        synchronized (this) {
            if (listAmenities == null) {
                listAmenities = listAmenitiesNew;
            }
        }
    }
    return listAmenities;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 751763565)
public synchronized void resetListAmenities() {
    listAmenities = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 981531844)
public List<EntryProfileEntity> getListProfiles() {
    if (listProfiles == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryProfileEntityDao targetDao = daoSession.getEntryProfileEntityDao();
        List<EntryProfileEntity> listProfilesNew = targetDao._queryEntryEntity_ListProfiles(id);
        synchronized (this) {
            if (listProfiles == null) {
                listProfiles = listProfilesNew;
            }
        }
    }
    return listProfiles;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1135385566)
public synchronized void resetListProfiles() {
    listProfiles = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1879476945)
public List<EntryLocationEntity> getListLocations() {
    if (listLocations == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryLocationEntityDao targetDao = daoSession.getEntryLocationEntityDao();
        List<EntryLocationEntity> listLocationsNew = targetDao._queryEntryEntity_ListLocations(id);
        synchronized (this) {
            if (listLocations == null) {
                listLocations = listLocationsNew;
            }
        }
    }
    return listLocations;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 904590150)
public synchronized void resetListLocations() {
    listLocations = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1646679056)
public List<EntryActivityEntity> getListActivities() {
    if (listActivities == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryActivityEntityDao targetDao = daoSession.getEntryActivityEntityDao();
        List<EntryActivityEntity> listActivitiesNew = targetDao
                ._queryEntryEntity_ListActivities(id);
        synchronized (this) {
            if (listActivities == null) {
                listActivities = listActivitiesNew;
            }
        }
    }
    return listActivities;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1346110965)
public synchronized void resetListActivities() {
    listActivities = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1378795989)
public List<EntryCategoryEntity> getListCategories() {
    if (listCategories == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryCategoryEntityDao targetDao = daoSession.getEntryCategoryEntityDao();
        List<EntryCategoryEntity> listCategoriesNew = targetDao
                ._queryEntryEntity_ListCategories(id);
        synchronized (this) {
            if (listCategories == null) {
                listCategories = listCategoriesNew;
            }
        }
    }
    return listCategories;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1090176073)
public synchronized void resetListCategories() {
    listCategories = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1643993262)
public List<EntryAtmospherEntity> getListAtmosphere() {
    if (listAtmosphere == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAtmospherEntityDao targetDao = daoSession.getEntryAtmospherEntityDao();
        List<EntryAtmospherEntity> listAtmosphereNew = targetDao
                ._queryEntryEntity_ListAtmosphere(id);
        synchronized (this) {
            if (listAtmosphere == null) {
                listAtmosphere = listAtmosphereNew;
            }
        }
    }
    return listAtmosphere;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 398917539)
public synchronized void resetListAtmosphere() {
    listAtmosphere = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 943367806)
public List<EntryAnimationEntity> getListAnimations() {
    if (listAnimations == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAnimationEntityDao targetDao = daoSession.getEntryAnimationEntityDao();
        List<EntryAnimationEntity> listAnimationsNew = targetDao
                ._queryEntryEntity_ListAnimations(id);
        synchronized (this) {
            if (listAnimations == null) {
                listAnimations = listAnimationsNew;
            }
        }
    }
    return listAnimations;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1105122505)
public synchronized void resetListAnimations() {
    listAnimations = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1387522862)
public List<EntryAffiliationEntity> getListAffiliations() {
    if (listAffiliations == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAffiliationEntityDao targetDao = daoSession.getEntryAffiliationEntityDao();
        List<EntryAffiliationEntity> listAffiliationsNew = targetDao
                ._queryEntryEntity_ListAffiliations(id);
        synchronized (this) {
            if (listAffiliations == null) {
                listAffiliations = listAffiliationsNew;
            }
        }
    }
    return listAffiliations;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1610585846)
public synchronized void resetListAffiliations() {
    listAffiliations = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1986248069)
public List<EntryStationEntity> getListStations() {
    if (listStations == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryStationEntityDao targetDao = daoSession.getEntryStationEntityDao();
        List<EntryStationEntity> listStationsNew = targetDao._queryEntryEntity_ListStations(id);
        synchronized (this) {
            if (listStations == null) {
                listStations = listStationsNew;
            }
        }
    }
    return listStations;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 804437585)
public synchronized void resetListStations() {
    listStations = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 963050693)
public List<EntryStandingLevelEntity> getListStandingLevels() {
    if (listStandingLevels == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryStandingLevelEntityDao targetDao = daoSession.getEntryStandingLevelEntityDao();
        List<EntryStandingLevelEntity> listStandingLevelsNew = targetDao
                ._queryEntryEntity_ListStandingLevels(id);
        synchronized (this) {
            if (listStandingLevels == null) {
                listStandingLevels = listStandingLevelsNew;
            }
        }
    }
    return listStandingLevels;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1337331632)
public synchronized void resetListStandingLevels() {
    listStandingLevels = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1139273611)
public List<EntryChainEntity> getListChains() {
    if (listChains == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryChainEntityDao targetDao = daoSession.getEntryChainEntityDao();
        List<EntryChainEntity> listChainsNew = targetDao._queryEntryEntity_ListChains(id);
        synchronized (this) {
            if (listChains == null) {
                listChains = listChainsNew;
            }
        }
    }
    return listChains;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1274970052)
public synchronized void resetListChains() {
    listChains = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1681152557)
public List<EntryServiceEntity> getListServices() {
    if (listServices == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryServiceEntityDao targetDao = daoSession.getEntryServiceEntityDao();
        List<EntryServiceEntity> listServicesNew = targetDao._queryEntryEntity_ListServices(id);
        synchronized (this) {
            if (listServices == null) {
                listServices = listServicesNew;
            }
        }
    }
    return listServices;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1612690718)
public synchronized void resetListServices() {
    listServices = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 886045091)
public List<EntryOptionEntity> getListOptions() {
    if (listOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryOptionEntityDao targetDao = daoSession.getEntryOptionEntityDao();
        List<EntryOptionEntity> listOptionsNew = targetDao._queryEntryEntity_ListOptions(id);
        synchronized (this) {
            if (listOptions == null) {
                listOptions = listOptionsNew;
            }
        }
    }
    return listOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 515900939)
public synchronized void resetListOptions() {
    listOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 687771094)
public List<EntryDisabledOptionEntity> getListDisabledOptions() {
    if (listDisabledOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryDisabledOptionEntityDao targetDao = daoSession.getEntryDisabledOptionEntityDao();
        List<EntryDisabledOptionEntity> listDisabledOptionsNew = targetDao
                ._queryEntryEntity_ListDisabledOptions(id);
        synchronized (this) {
            if (listDisabledOptions == null) {
                listDisabledOptions = listDisabledOptionsNew;
            }
        }
    }
    return listDisabledOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 125968042)
public synchronized void resetListDisabledOptions() {
    listDisabledOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1712406754)
public List<EntryFrpOptionEntity> getListFrpOptions() {
    if (listFrpOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryFrpOptionEntityDao targetDao = daoSession.getEntryFrpOptionEntityDao();
        List<EntryFrpOptionEntity> listFrpOptionsNew = targetDao
                ._queryEntryEntity_ListFrpOptions(id);
        synchronized (this) {
            if (listFrpOptions == null) {
                listFrpOptions = listFrpOptionsNew;
            }
        }
    }
    return listFrpOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1484766393)
public synchronized void resetListFrpOptions() {
    listFrpOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1305618901)
public List<EntryPoiOptionEntity> getListPoiOptions() {
    if (listPoiOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryPoiOptionEntityDao targetDao = daoSession.getEntryPoiOptionEntityDao();
        List<EntryPoiOptionEntity> listPoiOptionsNew = targetDao
                ._queryEntryEntity_ListPoiOptions(id);
        synchronized (this) {
            if (listPoiOptions == null) {
                listPoiOptions = listPoiOptionsNew;
            }
        }
    }
    return listPoiOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 208436416)
public synchronized void resetListPoiOptions() {
    listPoiOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1587686422)
public List<EntryPublicationEntity> getListPublications() {
    if (listPublications == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryPublicationEntityDao targetDao = daoSession.getEntryPublicationEntityDao();
        List<EntryPublicationEntity> listPublicationsNew = targetDao
                ._queryEntryEntity_ListPublications(id);
        synchronized (this) {
            if (listPublications == null) {
                listPublications = listPublicationsNew;
            }
        }
    }
    return listPublications;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 195492706)
public synchronized void resetListPublications() {
    listPublications = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1370744820)
public List<EntryCommonTagEntity> getListCommonTags() {
    if (listCommonTags == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryCommonTagEntityDao targetDao = daoSession.getEntryCommonTagEntityDao();
        List<EntryCommonTagEntity> listCommonTagsNew = targetDao
                ._queryEntryEntity_ListCommonTags(id);
        synchronized (this) {
            if (listCommonTags == null) {
                listCommonTags = listCommonTagsNew;
            }
        }
    }
    return listCommonTags;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 467164386)
public synchronized void resetListCommonTags() {
    listCommonTags = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1383378291)
public List<EntrySectorEntity> getListSectors() {
    if (listSectors == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntrySectorEntityDao targetDao = daoSession.getEntrySectorEntityDao();
        List<EntrySectorEntity> listSectorsNew = targetDao._queryEntryEntity_ListSectors(id);
        synchronized (this) {
            if (listSectors == null) {
                listSectors = listSectorsNew;
            }
        }
    }
    return listSectors;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1483554254)
public synchronized void resetListSectors() {
    listSectors = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 2041322412)
public List<EntryDescriptionEntity> getListDescriptions() {
    if (listDescriptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryDescriptionEntityDao targetDao = daoSession.getEntryDescriptionEntityDao();
        List<EntryDescriptionEntity> listDescriptionsNew = targetDao
                ._queryEntryEntity_ListDescriptions(id);
        synchronized (this) {
            if (listDescriptions == null) {
                listDescriptions = listDescriptionsNew;
            }
        }
    }
    return listDescriptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1925387837)
public synchronized void resetListDescriptions() {
    listDescriptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 2049838454)
public List<EntryImageEntity> getListImages() {
    if (listImages == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryImageEntityDao targetDao = daoSession.getEntryImageEntityDao();
        List<EntryImageEntity> listImagesNew = targetDao._queryEntryEntity_ListImages(id);
        synchronized (this) {
            if (listImages == null) {
                listImages = listImagesNew;
            }
        }
    }
    return listImages;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1152877506)
public synchronized void resetListImages() {
    listImages = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 608199708)
public List<EntryTariffEntity> getListTariffs() {
    if (listTariffs == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryTariffEntityDao targetDao = daoSession.getEntryTariffEntityDao();
        List<EntryTariffEntity> listTariffsNew = targetDao._queryEntryEntity_ListTariffs(id);
        synchronized (this) {
            if (listTariffs == null) {
                listTariffs = listTariffsNew;
            }
        }
    }
    return listTariffs;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 2062339290)
public synchronized void resetListTariffs() {
    listTariffs = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1363829308)
public List<EntryClosureEntity> getListClosures() {
    if (listClosures == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryClosureEntityDao targetDao = daoSession.getEntryClosureEntityDao();
        List<EntryClosureEntity> listClosuresNew = targetDao._queryEntryEntity_ListClosures(id);
        synchronized (this) {
            if (listClosures == null) {
                listClosures = listClosuresNew;
            }
        }
    }
    return listClosures;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1466156789)
public synchronized void resetListClosures() {
    listClosures = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1573089525)
public List<EntryCommerciaEntity> getListCommercia() {
    if (listCommercia == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryCommerciaEntityDao targetDao = daoSession.getEntryCommerciaEntityDao();
        List<EntryCommerciaEntity> listCommerciaNew = targetDao._queryEntryEntity_ListCommercia(id);
        synchronized (this) {
            if (listCommercia == null) {
                listCommercia = listCommerciaNew;
            }
        }
    }
    return listCommercia;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 635576947)
public synchronized void resetListCommercia() {
    listCommercia = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 102240955)
public List<EntrySpaceEntity> getListSpaces() {
    if (listSpaces == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntrySpaceEntityDao targetDao = daoSession.getEntrySpaceEntityDao();
        List<EntrySpaceEntity> listSpacesNew = targetDao._queryEntryEntity_ListSpaces(id);
        synchronized (this) {
            if (listSpaces == null) {
                listSpaces = listSpacesNew;
            }
        }
    }
    return listSpaces;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 84673251)
public synchronized void resetListSpaces() {
    listSpaces = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1544549817)
public List<EntryOpeningEntity> getListOpenings() {
    if (listOpenings == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryOpeningEntityDao targetDao = daoSession.getEntryOpeningEntityDao();
        List<EntryOpeningEntity> listOpeningsNew = targetDao._queryEntryEntity_ListOpenings(id);
        synchronized (this) {
            if (listOpenings == null) {
                listOpenings = listOpeningsNew;
            }
        }
    }
    return listOpenings;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 401760413)
public synchronized void resetListOpenings() {
    listOpenings = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 118509348)
public List<EntryClosingEntity> getListClosings() {
    if (listClosings == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryClosingEntityDao targetDao = daoSession.getEntryClosingEntityDao();
        List<EntryClosingEntity> listClosingsNew = targetDao._queryEntryEntity_ListClosings(id);
        synchronized (this) {
            if (listClosings == null) {
                listClosings = listClosingsNew;
            }
        }
    }
    return listClosings;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 258037397)
public synchronized void resetListClosings() {
    listClosings = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 669953800)
public List<EntryGroupOptionEntity> getListGroupOptions() {
    if (listGroupOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryGroupOptionEntityDao targetDao = daoSession.getEntryGroupOptionEntityDao();
        List<EntryGroupOptionEntity> listGroupOptionsNew = targetDao
                ._queryEntryEntity_ListGroupOptions(id);
        synchronized (this) {
            if (listGroupOptions == null) {
                listGroupOptions = listGroupOptionsNew;
            }
        }
    }
    return listGroupOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 965514078)
public synchronized void resetListGroupOptions() {
    listGroupOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1189326772)
public List<EntryFamilyOptionEntity> getListFamilyOptions() {
    if (listFamilyOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryFamilyOptionEntityDao targetDao = daoSession.getEntryFamilyOptionEntityDao();
        List<EntryFamilyOptionEntity> listFamilyOptionsNew = targetDao
                ._queryEntryEntity_ListFamilyOptions(id);
        synchronized (this) {
            if (listFamilyOptions == null) {
                listFamilyOptions = listFamilyOptionsNew;
            }
        }
    }
    return listFamilyOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 677514775)
public synchronized void resetListFamilyOptions() {
    listFamilyOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 173990776)
public List<EntryAllianceOptionEntity> getListAllianceOptions() {
    if (listAllianceOptions == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryAllianceOptionEntityDao targetDao = daoSession.getEntryAllianceOptionEntityDao();
        List<EntryAllianceOptionEntity> listAllianceOptionsNew = targetDao
                ._queryEntryEntity_ListAllianceOptions(id);
        synchronized (this) {
            if (listAllianceOptions == null) {
                listAllianceOptions = listAllianceOptionsNew;
            }
        }
    }
    return listAllianceOptions;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 362650387)
public synchronized void resetListAllianceOptions() {
    listAllianceOptions = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1347438571)
public List<EntryFurnishedRentalEntity> getListFurnishedRentals() {
    if (listFurnishedRentals == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryFurnishedRentalEntityDao targetDao = daoSession.getEntryFurnishedRentalEntityDao();
        List<EntryFurnishedRentalEntity> listFurnishedRentalsNew = targetDao
                ._queryEntryEntity_ListFurnishedRentals(id);
        synchronized (this) {
            if (listFurnishedRentals == null) {
                listFurnishedRentals = listFurnishedRentalsNew;
            }
        }
    }
    return listFurnishedRentals;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 316224779)
public synchronized void resetListFurnishedRentals() {
    listFurnishedRentals = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 490963333)
public List<EntryRentalMonthEntity> getListRentalMonths() {
    if (listRentalMonths == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntryRentalMonthEntityDao targetDao = daoSession.getEntryRentalMonthEntityDao();
        List<EntryRentalMonthEntity> listRentalMonthsNew = targetDao
                ._queryEntryEntity_ListRentalMonths(id);
        synchronized (this) {
            if (listRentalMonths == null) {
                listRentalMonths = listRentalMonthsNew;
            }
        }
    }
    return listRentalMonths;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 1677146486)
public synchronized void resetListRentalMonths() {
    listRentalMonths = null;
}





/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1849478505)
public List<EntrySleepingEntity> getListSleepings() {
    if (listSleepings == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        EntrySleepingEntityDao targetDao = daoSession.getEntrySleepingEntityDao();
        List<EntrySleepingEntity> listSleepingsNew = targetDao._queryEntryEntity_ListSleepings(id);
        synchronized (this) {
            if (listSleepings == null) {
                listSleepings = listSleepingsNew;
            }
        }
    }
    return listSleepings;
}





/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 289613639)
public synchronized void resetListSleepings() {
    listSleepings = null;
}





/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 128553479)
public void delete() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.delete(this);
}





/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 1942392019)
public void refresh() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.refresh(this);
}





/**
 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
 * Entity must attached to an entity context.
 */
@Generated(hash = 713229351)
public void update() {
    if (myDao == null) {
        throw new DaoException("Entity is detached from DAO context");
    }
    myDao.update(this);
}





/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1579925774)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getEntryEntityDao() : null;
}





    public static class EntriesTypeConverter implements PropertyConverter<EntriesType, String> {
        @Override
        public EntriesType convertToEntityProperty(String databaseValue) {
            return EntriesType.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(EntriesType entityProperty) {
            return entityProperty.name();
        }
    }

}
