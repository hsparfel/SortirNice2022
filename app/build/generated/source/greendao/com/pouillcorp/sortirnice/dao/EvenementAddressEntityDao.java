package com.pouillcorp.sortirnice.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementAddressEntity;

import com.pouillcorp.sortirnice.entities.event.detail.EvenementAddressEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EVENEMENT_ADDRESS_ENTITY".
*/
public class EvenementAddressEntityDao extends AbstractDao<EvenementAddressEntity, Long> {

    public static final String TABLENAME = "EVENEMENT_ADDRESS_ENTITY";

    /**
     * Properties of entity EvenementAddressEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AddressContent = new Property(1, String.class, "addressContent", false, "ADDRESS_CONTENT");
        public final static Property Zip = new Property(2, String.class, "zip", false, "ZIP");
        public final static Property City = new Property(3, String.class, "city", false, "CITY");
        public final static Property Type = new Property(4, String.class, "type", false, "TYPE");
        public final static Property IsChecked = new Property(5, boolean.class, "isChecked", false, "IS_CHECKED");
    }

    private Query<EvenementAddressEntity> evenementEntity_ListAddressesQuery;

    public EvenementAddressEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EvenementAddressEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EVENEMENT_ADDRESS_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ADDRESS_CONTENT\" TEXT," + // 1: addressContent
                "\"ZIP\" TEXT," + // 2: zip
                "\"CITY\" TEXT," + // 3: city
                "\"TYPE\" TEXT," + // 4: type
                "\"IS_CHECKED\" INTEGER NOT NULL );"); // 5: isChecked
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EVENEMENT_ADDRESS_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EvenementAddressEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String addressContent = entity.getAddressContent();
        if (addressContent != null) {
            stmt.bindString(2, addressContent);
        }
 
        String zip = entity.getZip();
        if (zip != null) {
            stmt.bindString(3, zip);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(4, city);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
        stmt.bindLong(6, entity.getIsChecked() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, EvenementAddressEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String addressContent = entity.getAddressContent();
        if (addressContent != null) {
            stmt.bindString(2, addressContent);
        }
 
        String zip = entity.getZip();
        if (zip != null) {
            stmt.bindString(3, zip);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(4, city);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(5, type);
        }
        stmt.bindLong(6, entity.getIsChecked() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public EvenementAddressEntity readEntity(Cursor cursor, int offset) {
        EvenementAddressEntity entity = new EvenementAddressEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // addressContent
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // zip
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // city
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // type
            cursor.getShort(offset + 5) != 0 // isChecked
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EvenementAddressEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAddressContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setZip(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCity(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsChecked(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EvenementAddressEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EvenementAddressEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EvenementAddressEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listAddresses" to-many relationship of EvenementEntity. */
    public List<EvenementAddressEntity> _queryEvenementEntity_ListAddresses(Long evenementEntityId) {
        synchronized (this) {
            if (evenementEntity_ListAddressesQuery == null) {
                QueryBuilder<EvenementAddressEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEvenementEntityWithEvenementAddressEntity.class, JoinEvenementEntityWithEvenementAddressEntityDao.Properties.EvenementAddressEntityId)
                    .where(JoinEvenementEntityWithEvenementAddressEntityDao.Properties.EvenementEntityId.eq(evenementEntityId));
                evenementEntity_ListAddressesQuery = queryBuilder.build();
            }
        }
        Query<EvenementAddressEntity> query = evenementEntity_ListAddressesQuery.forCurrentThread();
        query.setParameter(0, evenementEntityId);
        return query.list();
    }

}