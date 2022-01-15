package com.pouillcorp.sortirnice.entities.event;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementDescriptionEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementRefEntriesEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementSectoEntity;
import com.pouillcorp.sortirnice.entities.event.detail.EvenementStationEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementAddressEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementCategoryEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementDescriptionEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementOptionEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementProfileEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementRefEntriesEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementSectoEntity;
import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementStationEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Comparator;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.pouillcorp.sortirnice.dao.DaoSession;
import com.pouillcorp.sortirnice.dao.EvenementRefEntriesEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementDescriptionEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementSectoEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementOptionEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementCategoryEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementStationEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementProfileEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementAddressEntityDao;
import com.pouillcorp.sortirnice.dao.EvenementEntityDao;

@Entity
public class EvenementEntity implements Comparable<EvenementEntity> {

    @Id
    private Long id;

    private Long evenementEntityId;

    private String nameFr;

    private String start;

    private String end;

    //private String adressSituationContent;

    //private String adressSituationZip;

    //private String adressSituationCity;

    //private String adressPrincipalContent;

    //private String adressPrincipalZip;

    //private String adressPrincipalCity;

    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementAddressEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementAddressEntityId")
    private List<EvenementAddressEntity> listAddresses;

    private String phone;

    private String email;

    private String websiteSituation;

    private String websitePrincipal;

    /*
     * Comparator pour le tri des employés par nom
     */
    public static Comparator<EvenementEntity> ComparatorDate = new Comparator<EvenementEntity>() {
        @Override
        public int compare(EvenementEntity e1, EvenementEntity e2) {
            return e1.getStart().compareTo(e2.getStart());
        }
    };

    //private String profile;
    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementProfileEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementProfileEntityId")
    private List<EvenementProfileEntity> listProfiles;

    //private String station;
    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementStationEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementStationEntityId")
    private List<EvenementStationEntity> listStations;

    //private String category;
    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementCategoryEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementCategoryEntityId")
    private List<EvenementCategoryEntity> listCategories;

    //private String option;
    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementOptionEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementOptionEntityId")
    private List<EvenementOptionEntity> listOptions;

    //private String secto;
    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementSectoEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementSectoEntityId")
    private List<EvenementSectoEntity> listSectos;

    //private String descriptionSituation;

    //private String descriptionHoraires;

    //private String descriptionTarification;

    //private String descriptionDescription;

    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementDescriptionEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementDescriptionEntityId")
    private List<EvenementDescriptionEntity> listDescriptions;

    private String image;

    private double latitude;

    private double longitude;

    private int note;

    //private String entryId;

    //private String entryName;

    private String created;

    private String updated;

    @ToMany
    @JoinEntity(entity = JoinEvenementEntityWithEvenementRefEntriesEntity.class,
            sourceProperty = "evenementEntityId",
            targetProperty = "evenementRefEntriesEntityId")
    private List<EvenementRefEntriesEntity> listRefEntries;


    private boolean favori;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 98208140)
    private transient EvenementEntityDao myDao;

    @Generated(hash = 1313720565)
    public EvenementEntity(Long id, Long evenementEntityId, String nameFr, String start, String end,
            String phone, String email, String websiteSituation, String websitePrincipal, String image,
            double latitude, double longitude, int note, String created, String updated,
            boolean favori) {
        this.id = id;
        this.evenementEntityId = evenementEntityId;
        this.nameFr = nameFr;
        this.start = start;
        this.end = end;
        this.phone = phone;
        this.email = email;
        this.websiteSituation = websiteSituation;
        this.websitePrincipal = websitePrincipal;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.note = note;
        this.created = created;
        this.updated = updated;
        this.favori = favori;
    }

    @Generated(hash = 367584197)
    public EvenementEntity() {
    }


    @Override
    public int compareTo(EvenementEntity o) {
        return this.getNameFr().compareTo(o.getNameFr());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvenementEntityId() {
        return evenementEntityId;
    }

    public void setEvenementEntityId(Long evenementEntityId) {
        this.evenementEntityId = evenementEntityId;
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

    

    public void setListAddresses(List<EvenementAddressEntity> listAddresses) {
        this.listAddresses = listAddresses;
    }



    public void setListProfiles(List<EvenementProfileEntity> listProfiles) {
        this.listProfiles = listProfiles;
    }



    public void setListStations(List<EvenementStationEntity> listStations) {
        this.listStations = listStations;
    }



    public void setListCategories(List<EvenementCategoryEntity> listCategories) {
        this.listCategories = listCategories;
    }



    public void setListOptions(List<EvenementOptionEntity> listOptions) {
        this.listOptions = listOptions;
    }



    public void setListSectos(List<EvenementSectoEntity> listSectos) {
        this.listSectos = listSectos;
    }



    public void setListDescriptions(List<EvenementDescriptionEntity> listDescriptions) {
        this.listDescriptions = listDescriptions;
    }



    public void setListRefEntries(List<EvenementRefEntriesEntity> listRefEntries) {
        this.listRefEntries = listRefEntries;
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 760044796)
    public List<EvenementAddressEntity> getListAddresses() {
        if (listAddresses == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementAddressEntityDao targetDao = daoSession.getEvenementAddressEntityDao();
            List<EvenementAddressEntity> listAddressesNew = targetDao
                    ._queryEvenementEntity_ListAddresses(id);
            synchronized (this) {
                if (listAddresses == null) {
                    listAddresses = listAddressesNew;
                }
            }
        }
        return listAddresses;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 148488853)
    public synchronized void resetListAddresses() {
        listAddresses = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 773367632)
    public List<EvenementProfileEntity> getListProfiles() {
        if (listProfiles == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementProfileEntityDao targetDao = daoSession.getEvenementProfileEntityDao();
            List<EvenementProfileEntity> listProfilesNew = targetDao
                    ._queryEvenementEntity_ListProfiles(id);
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
    @Generated(hash = 1234558817)
    public List<EvenementStationEntity> getListStations() {
        if (listStations == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementStationEntityDao targetDao = daoSession.getEvenementStationEntityDao();
            List<EvenementStationEntity> listStationsNew = targetDao
                    ._queryEvenementEntity_ListStations(id);
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
    @Generated(hash = 1075993973)
    public List<EvenementCategoryEntity> getListCategories() {
        if (listCategories == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementCategoryEntityDao targetDao = daoSession.getEvenementCategoryEntityDao();
            List<EvenementCategoryEntity> listCategoriesNew = targetDao
                    ._queryEvenementEntity_ListCategories(id);
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
    @Generated(hash = 1395233586)
    public List<EvenementOptionEntity> getListOptions() {
        if (listOptions == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementOptionEntityDao targetDao = daoSession.getEvenementOptionEntityDao();
            List<EvenementOptionEntity> listOptionsNew = targetDao
                    ._queryEvenementEntity_ListOptions(id);
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
    @Generated(hash = 817650896)
    public List<EvenementSectoEntity> getListSectos() {
        if (listSectos == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementSectoEntityDao targetDao = daoSession.getEvenementSectoEntityDao();
            List<EvenementSectoEntity> listSectosNew = targetDao._queryEvenementEntity_ListSectos(id);
            synchronized (this) {
                if (listSectos == null) {
                    listSectos = listSectosNew;
                }
            }
        }
        return listSectos;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1713892776)
    public synchronized void resetListSectos() {
        listSectos = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 888534078)
    public List<EvenementDescriptionEntity> getListDescriptions() {
        if (listDescriptions == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementDescriptionEntityDao targetDao = daoSession.getEvenementDescriptionEntityDao();
            List<EvenementDescriptionEntity> listDescriptionsNew = targetDao
                    ._queryEvenementEntity_ListDescriptions(id);
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
    @Generated(hash = 1396431652)
    public List<EvenementRefEntriesEntity> getListRefEntries() {
        if (listRefEntries == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EvenementRefEntriesEntityDao targetDao = daoSession.getEvenementRefEntriesEntityDao();
            List<EvenementRefEntriesEntity> listRefEntriesNew = targetDao
                    ._queryEvenementEntity_ListRefEntries(id);
            synchronized (this) {
                if (listRefEntries == null) {
                    listRefEntries = listRefEntriesNew;
                }
            }
        }
        return listRefEntries;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 168025508)
    public synchronized void resetListRefEntries() {
        listRefEntries = null;
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
    @Generated(hash = 1460498720)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEvenementEntityDao() : null;
    }

}
