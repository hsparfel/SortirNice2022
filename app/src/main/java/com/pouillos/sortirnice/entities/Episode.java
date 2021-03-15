package com.pouillos.sortirnice.entities;


import com.pouillos.sortirnice.dao.DaoSession;
import com.pouillos.sortirnice.dao.EpisodeDao;
import com.pouillos.sortirnice.dao.SaisonDao;
import com.pouillos.sortirnice.utils.BasicUtils;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity
public class Episode implements Comparable<Episode> {

    @Id
    private Long id;

    private long saisonId;
    @ToOne(joinProperty = "saisonId")
    private Saison saison;

    private int numEpisode;

    boolean vu;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 494421999)
    private transient EpisodeDao myDao;

    @Generated(hash = 1832009349)
    public Episode(Long id, long saisonId, int numEpisode, boolean vu) {
        this.id = id;
        this.saisonId = saisonId;
        this.numEpisode = numEpisode;
        this.vu = vu;
    }

    @Generated(hash = 1336866052)
    public Episode() {
    }

    @Generated(hash = 1816053175)
    private transient Long saison__resolvedKey;

    @Override
    public String toString() {
        return "Episode "+ BasicUtils.afficherChiffre(this.numEpisode) +((this.getVu()) ? " - vu" :"");
    }

    @Override
    public int compareTo(Episode o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSaisonId() {
        return this.saisonId;
    }

    public void setSaisonId(long saisonId) {
        this.saisonId = saisonId;
    }

    public int getNumEpisode() {
        return this.numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    public boolean getVu() {
        return this.vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1605337579)
    public Saison getSaison() {
        long __key = this.saisonId;
        if (saison__resolvedKey == null || !saison__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SaisonDao targetDao = daoSession.getSaisonDao();
            Saison saisonNew = targetDao.load(__key);
            synchronized (this) {
                saison = saisonNew;
                saison__resolvedKey = __key;
            }
        }
        return saison;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1496204931)
    public void setSaison(@NotNull Saison saison) {
        if (saison == null) {
            throw new DaoException(
                    "To-one property 'saisonId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.saison = saison;
            saisonId = saison.getId();
            saison__resolvedKey = saisonId;
        }
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
    @Generated(hash = 153634245)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEpisodeDao() : null;
    }

    
}
