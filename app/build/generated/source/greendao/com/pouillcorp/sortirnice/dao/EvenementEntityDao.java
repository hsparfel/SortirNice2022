package com.pouillcorp.sortirnice.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pouillcorp.sortirnice.entities.event.EvenementEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EVENEMENT_ENTITY".
*/
public class EvenementEntityDao extends AbstractDao<EvenementEntity, Long> {

    public static final String TABLENAME = "EVENEMENT_ENTITY";

    /**
     * Properties of entity EvenementEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EvenementEntityId = new Property(1, Long.class, "evenementEntityId", false, "EVENEMENT_ENTITY_ID");
        public final static Property NameFr = new Property(2, String.class, "nameFr", false, "NAME_FR");
        public final static Property Start = new Property(3, String.class, "start", false, "START");
        public final static Property End = new Property(4, String.class, "end", false, "END");
        public final static Property Phone = new Property(5, String.class, "phone", false, "PHONE");
        public final static Property Email = new Property(6, String.class, "email", false, "EMAIL");
        public final static Property WebsiteSituation = new Property(7, String.class, "websiteSituation", false, "WEBSITE_SITUATION");
        public final static Property WebsitePrincipal = new Property(8, String.class, "websitePrincipal", false, "WEBSITE_PRINCIPAL");
        public final static Property Image = new Property(9, String.class, "image", false, "IMAGE");
        public final static Property Latitude = new Property(10, double.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(11, double.class, "longitude", false, "LONGITUDE");
        public final static Property Note = new Property(12, int.class, "note", false, "NOTE");
        public final static Property Created = new Property(13, String.class, "created", false, "CREATED");
        public final static Property Updated = new Property(14, String.class, "updated", false, "UPDATED");
        public final static Property Favori = new Property(15, boolean.class, "favori", false, "FAVORI");
    }

    private DaoSession daoSession;


    public EvenementEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EvenementEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EVENEMENT_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"EVENEMENT_ENTITY_ID\" INTEGER," + // 1: evenementEntityId
                "\"NAME_FR\" TEXT," + // 2: nameFr
                "\"START\" TEXT," + // 3: start
                "\"END\" TEXT," + // 4: end
                "\"PHONE\" TEXT," + // 5: phone
                "\"EMAIL\" TEXT," + // 6: email
                "\"WEBSITE_SITUATION\" TEXT," + // 7: websiteSituation
                "\"WEBSITE_PRINCIPAL\" TEXT," + // 8: websitePrincipal
                "\"IMAGE\" TEXT," + // 9: image
                "\"LATITUDE\" REAL NOT NULL ," + // 10: latitude
                "\"LONGITUDE\" REAL NOT NULL ," + // 11: longitude
                "\"NOTE\" INTEGER NOT NULL ," + // 12: note
                "\"CREATED\" TEXT," + // 13: created
                "\"UPDATED\" TEXT," + // 14: updated
                "\"FAVORI\" INTEGER NOT NULL );"); // 15: favori
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EVENEMENT_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EvenementEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long evenementEntityId = entity.getEvenementEntityId();
        if (evenementEntityId != null) {
            stmt.bindLong(2, evenementEntityId);
        }
 
        String nameFr = entity.getNameFr();
        if (nameFr != null) {
            stmt.bindString(3, nameFr);
        }
 
        String start = entity.getStart();
        if (start != null) {
            stmt.bindString(4, start);
        }
 
        String end = entity.getEnd();
        if (end != null) {
            stmt.bindString(5, end);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String websiteSituation = entity.getWebsiteSituation();
        if (websiteSituation != null) {
            stmt.bindString(8, websiteSituation);
        }
 
        String websitePrincipal = entity.getWebsitePrincipal();
        if (websitePrincipal != null) {
            stmt.bindString(9, websitePrincipal);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(10, image);
        }
        stmt.bindDouble(11, entity.getLatitude());
        stmt.bindDouble(12, entity.getLongitude());
        stmt.bindLong(13, entity.getNote());
 
        String created = entity.getCreated();
        if (created != null) {
            stmt.bindString(14, created);
        }
 
        String updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindString(15, updated);
        }
        stmt.bindLong(16, entity.getFavori() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, EvenementEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long evenementEntityId = entity.getEvenementEntityId();
        if (evenementEntityId != null) {
            stmt.bindLong(2, evenementEntityId);
        }
 
        String nameFr = entity.getNameFr();
        if (nameFr != null) {
            stmt.bindString(3, nameFr);
        }
 
        String start = entity.getStart();
        if (start != null) {
            stmt.bindString(4, start);
        }
 
        String end = entity.getEnd();
        if (end != null) {
            stmt.bindString(5, end);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String websiteSituation = entity.getWebsiteSituation();
        if (websiteSituation != null) {
            stmt.bindString(8, websiteSituation);
        }
 
        String websitePrincipal = entity.getWebsitePrincipal();
        if (websitePrincipal != null) {
            stmt.bindString(9, websitePrincipal);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(10, image);
        }
        stmt.bindDouble(11, entity.getLatitude());
        stmt.bindDouble(12, entity.getLongitude());
        stmt.bindLong(13, entity.getNote());
 
        String created = entity.getCreated();
        if (created != null) {
            stmt.bindString(14, created);
        }
 
        String updated = entity.getUpdated();
        if (updated != null) {
            stmt.bindString(15, updated);
        }
        stmt.bindLong(16, entity.getFavori() ? 1L: 0L);
    }

    @Override
    protected final void attachEntity(EvenementEntity entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public EvenementEntity readEntity(Cursor cursor, int offset) {
        EvenementEntity entity = new EvenementEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // evenementEntityId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // nameFr
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // start
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // end
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // phone
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // email
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // websiteSituation
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // websitePrincipal
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // image
            cursor.getDouble(offset + 10), // latitude
            cursor.getDouble(offset + 11), // longitude
            cursor.getInt(offset + 12), // note
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // created
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // updated
            cursor.getShort(offset + 15) != 0 // favori
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EvenementEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEvenementEntityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setNameFr(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStart(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEnd(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEmail(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setWebsiteSituation(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setWebsitePrincipal(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setImage(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setLatitude(cursor.getDouble(offset + 10));
        entity.setLongitude(cursor.getDouble(offset + 11));
        entity.setNote(cursor.getInt(offset + 12));
        entity.setCreated(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setUpdated(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setFavori(cursor.getShort(offset + 15) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EvenementEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EvenementEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EvenementEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
