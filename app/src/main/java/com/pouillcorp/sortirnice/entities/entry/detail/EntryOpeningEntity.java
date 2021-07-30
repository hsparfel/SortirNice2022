package com.pouillcorp.sortirnice.entities.entry.detail;

import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryOpeningEntityWithEntryGridEntity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.pouillcorp.sortirnice.dao.DaoSession;
import com.pouillcorp.sortirnice.dao.EntryGridEntityDao;
import com.pouillcorp.sortirnice.dao.EntryOpeningEntityDao;

@Entity
public class EntryOpeningEntity implements Comparable<EntryOpeningEntity> {

    @Id
    private Long id;

    private String openingStart;

    private String openingEnd;

    private String openingReplay;

    @ToMany
    @JoinEntity(entity = JoinEntryOpeningEntityWithEntryGridEntity.class,
            sourceProperty = "entryOpeningEntityId",
            targetProperty = "entryGridEntityId")
    private List<EntryGridEntity> listGrids;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 851067170)
    private transient EntryOpeningEntityDao myDao;

    @Generated(hash = 1689165897)
    public EntryOpeningEntity(Long id, String openingStart, String openingEnd,
            String openingReplay) {
        this.id = id;
        this.openingStart = openingStart;
        this.openingEnd = openingEnd;
        this.openingReplay = openingReplay;
    }

    @Generated(hash = 398802870)
    public EntryOpeningEntity() {
    }

    @Override
    public int compareTo(EntryOpeningEntity o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpeningStart() {
        return this.openingStart;
    }

    public void setOpeningStart(String openingStart) {
        this.openingStart = openingStart;
    }

    public String getOpeningEnd() {
        return this.openingEnd;
    }

    public void setOpeningEnd(String openingEnd) {
        this.openingEnd = openingEnd;
    }

    public String getOpeningReplay() {
        return this.openingReplay;
    }

    public void setOpeningReplay(String openingReplay) {
        this.openingReplay = openingReplay;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1813861534)
    public List<EntryGridEntity> getListGrids() {
        if (listGrids == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EntryGridEntityDao targetDao = daoSession.getEntryGridEntityDao();
            List<EntryGridEntity> listGridsNew = targetDao
                    ._queryEntryOpeningEntity_ListGrids(id);
            synchronized (this) {
                if (listGrids == null) {
                    listGrids = listGridsNew;
                }
            }
        }
        return listGrids;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 497707698)
    public synchronized void resetListGrids() {
        listGrids = null;
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
    @Generated(hash = 309920153)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEntryOpeningEntityDao() : null;
    }

}
