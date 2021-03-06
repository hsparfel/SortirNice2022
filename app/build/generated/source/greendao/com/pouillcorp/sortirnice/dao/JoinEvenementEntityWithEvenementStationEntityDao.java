package com.pouillcorp.sortirnice.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementStationEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_EVENEMENT_ENTITY_WITH_EVENEMENT_STATION_ENTITY".
*/
public class JoinEvenementEntityWithEvenementStationEntityDao extends AbstractDao<JoinEvenementEntityWithEvenementStationEntity, Long> {

    public static final String TABLENAME = "JOIN_EVENEMENT_ENTITY_WITH_EVENEMENT_STATION_ENTITY";

    /**
     * Properties of entity JoinEvenementEntityWithEvenementStationEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EvenementEntityId = new Property(1, Long.class, "evenementEntityId", false, "EVENEMENT_ENTITY_ID");
        public final static Property EvenementStationEntityId = new Property(2, Long.class, "evenementStationEntityId", false, "EVENEMENT_STATION_ENTITY_ID");
    }


    public JoinEvenementEntityWithEvenementStationEntityDao(DaoConfig config) {
        super(config);
    }
    
    public JoinEvenementEntityWithEvenementStationEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_EVENEMENT_ENTITY_WITH_EVENEMENT_STATION_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"EVENEMENT_ENTITY_ID\" INTEGER," + // 1: evenementEntityId
                "\"EVENEMENT_STATION_ENTITY_ID\" INTEGER);"); // 2: evenementStationEntityId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_EVENEMENT_ENTITY_WITH_EVENEMENT_STATION_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinEvenementEntityWithEvenementStationEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long evenementEntityId = entity.getEvenementEntityId();
        if (evenementEntityId != null) {
            stmt.bindLong(2, evenementEntityId);
        }
 
        Long evenementStationEntityId = entity.getEvenementStationEntityId();
        if (evenementStationEntityId != null) {
            stmt.bindLong(3, evenementStationEntityId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinEvenementEntityWithEvenementStationEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long evenementEntityId = entity.getEvenementEntityId();
        if (evenementEntityId != null) {
            stmt.bindLong(2, evenementEntityId);
        }
 
        Long evenementStationEntityId = entity.getEvenementStationEntityId();
        if (evenementStationEntityId != null) {
            stmt.bindLong(3, evenementStationEntityId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public JoinEvenementEntityWithEvenementStationEntity readEntity(Cursor cursor, int offset) {
        JoinEvenementEntityWithEvenementStationEntity entity = new JoinEvenementEntityWithEvenementStationEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // evenementEntityId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // evenementStationEntityId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinEvenementEntityWithEvenementStationEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEvenementEntityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setEvenementStationEntityId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(JoinEvenementEntityWithEvenementStationEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(JoinEvenementEntityWithEvenementStationEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(JoinEvenementEntityWithEvenementStationEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
