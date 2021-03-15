package com.pouillos.sortirnice.entities;


import com.pouillos.sortirnice.dao.DaoSession;
import com.pouillos.sortirnice.dao.SaisonDao;
import com.pouillos.sortirnice.dao.SerieDao;
import com.pouillos.sortirnice.enumeration.Langage;
import com.pouillos.sortirnice.utils.BasicUtils;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.converter.PropertyConverter;

@Entity
public class Saison implements Comparable<Saison> {

    @Id
    private Long id;

    private long serieId;
    @ToOne(joinProperty = "serieId")
    private Serie serie;

    private int numSaison;
    private int nbEpisodes;

    @Convert(converter = LangageConverter.class, columnType = String.class)
    private Langage langage;

    boolean vu;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1061170921)
    private transient SaisonDao myDao;


    @Generated(hash = 1169297404)
    public Saison(Long id, long serieId, int numSaison, int nbEpisodes, Langage langage, boolean vu) {
        this.id = id;
        this.serieId = serieId;
        this.numSaison = numSaison;
        this.nbEpisodes = nbEpisodes;
        this.langage = langage;
        this.vu = vu;
    }

    @Generated(hash = 1761143781)
    public Saison() {
    }


    @Generated(hash = 801892098)
    private transient Long serie__resolvedKey;

    
    @Override
    public String toString() {
        /*String string = "";
        string += this.getSerie()+" - ";
        if (this.getNumSaison()<10) {
            string += "0";
        }
        string += this.getNumSaison()+" - ";


        return string;*/
        return "Saison "+ BasicUtils.afficherChiffre(this.numSaison)+" - "+this.getNbEpisodes()+" episodes - "+this.getLangage() +((this.getVu()) ? " - vu" :"");
    }

    @Override
    public int compareTo(Saison o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSerieId() {
        return this.serieId;
    }

    public void setSerieId(long serieId) {
        this.serieId = serieId;
    }

    public int getNumSaison() {
        return this.numSaison;
    }

    public void setNumSaison(int numSaison) {
        this.numSaison = numSaison;
    }

    public int getNbEpisodes() {
        return this.nbEpisodes;
    }

    public void setNbEpisodes(int nbEpisodes) {
        this.nbEpisodes = nbEpisodes;
    }

    public Langage getLangage() {
        return this.langage;
    }

    public void setLangage(Langage langage) {
        this.langage = langage;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 806585660)
    public Serie getSerie() {
        long __key = this.serieId;
        if (serie__resolvedKey == null || !serie__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SerieDao targetDao = daoSession.getSerieDao();
            Serie serieNew = targetDao.load(__key);
            synchronized (this) {
                serie = serieNew;
                serie__resolvedKey = __key;
            }
        }
        return serie;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1786307989)
    public void setSerie(@NotNull Serie serie) {
        if (serie == null) {
            throw new DaoException(
                    "To-one property 'serieId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.serie = serie;
            serieId = serie.getId();
            serie__resolvedKey = serieId;
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
    @Generated(hash = 337292106)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSaisonDao() : null;
    }

    public boolean getVu() {
        return this.vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }


    public static class LangageConverter implements PropertyConverter<Langage, String> {
        @Override
        public Langage convertToEntityProperty(String databaseValue) {
            return Langage.valueOf(databaseValue);
        }

        @Override
        public String convertToDatabaseValue(Langage entityProperty) {
            return entityProperty.name();
        }
    }
    
}
