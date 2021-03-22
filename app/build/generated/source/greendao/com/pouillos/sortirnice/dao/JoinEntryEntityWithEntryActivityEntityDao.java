package com.pouillos.sortirnice.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryActivityEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_ENTRY_ENTITY_WITH_ENTRY_ACTIVITY_ENTITY".
*/
public class JoinEntryEntityWithEntryActivityEntityDao extends AbstractDao<JoinEntryEntityWithEntryActivityEntity, Long> {

    public static final String TABLENAME = "JOIN_ENTRY_ENTITY_WITH_ENTRY_ACTIVITY_ENTITY";

    /**
     * Properties of entity JoinEntryEntityWithEntryActivityEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EntryEntityId = new Property(1, Long.class, "entryEntityId", false, "ENTRY_ENTITY_ID");
        public final static Property EntryActivityEntityId = new Property(2, Long.class, "entryActivityEntityId", false, "ENTRY_ACTIVITY_ENTITY_ID");
    }


    public JoinEntryEntityWithEntryActivityEntityDao(DaoConfig config) {
        super(config);
    }
    
    public JoinEntryEntityWithEntryActivityEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_ENTRY_ENTITY_WITH_ENTRY_ACTIVITY_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ENTRY_ENTITY_ID\" INTEGER," + // 1: entryEntityId
                "\"ENTRY_ACTIVITY_ENTITY_ID\" INTEGER);"); // 2: entryActivityEntityId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_ENTRY_ENTITY_WITH_ENTRY_ACTIVITY_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinEntryEntityWithEntryActivityEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryEntityId = entity.getEntryEntityId();
        if (entryEntityId != null) {
            stmt.bindLong(2, entryEntityId);
        }
 
        Long entryActivityEntityId = entity.getEntryActivityEntityId();
        if (entryActivityEntityId != null) {
            stmt.bindLong(3, entryActivityEntityId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinEntryEntityWithEntryActivityEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryEntityId = entity.getEntryEntityId();
        if (entryEntityId != null) {
            stmt.bindLong(2, entryEntityId);
        }
 
        Long entryActivityEntityId = entity.getEntryActivityEntityId();
        if (entryActivityEntityId != null) {
            stmt.bindLong(3, entryActivityEntityId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public JoinEntryEntityWithEntryActivityEntity readEntity(Cursor cursor, int offset) {
        JoinEntryEntityWithEntryActivityEntity entity = new JoinEntryEntityWithEntryActivityEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // entryEntityId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // entryActivityEntityId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinEntryEntityWithEntryActivityEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEntryEntityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setEntryActivityEntityId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(JoinEntryEntityWithEntryActivityEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(JoinEntryEntityWithEntryActivityEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(JoinEntryEntityWithEntryActivityEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
