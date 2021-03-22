package com.pouillos.sortirnice.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryProfileEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_ENTRY_ENTITY_WITH_ENTRY_PROFILE_ENTITY".
*/
public class JoinEntryEntityWithEntryProfileEntityDao extends AbstractDao<JoinEntryEntityWithEntryProfileEntity, Long> {

    public static final String TABLENAME = "JOIN_ENTRY_ENTITY_WITH_ENTRY_PROFILE_ENTITY";

    /**
     * Properties of entity JoinEntryEntityWithEntryProfileEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EntryEntityId = new Property(1, Long.class, "entryEntityId", false, "ENTRY_ENTITY_ID");
        public final static Property EntryProfileEntityId = new Property(2, Long.class, "entryProfileEntityId", false, "ENTRY_PROFILE_ENTITY_ID");
    }


    public JoinEntryEntityWithEntryProfileEntityDao(DaoConfig config) {
        super(config);
    }
    
    public JoinEntryEntityWithEntryProfileEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_ENTRY_ENTITY_WITH_ENTRY_PROFILE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ENTRY_ENTITY_ID\" INTEGER," + // 1: entryEntityId
                "\"ENTRY_PROFILE_ENTITY_ID\" INTEGER);"); // 2: entryProfileEntityId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_ENTRY_ENTITY_WITH_ENTRY_PROFILE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinEntryEntityWithEntryProfileEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryEntityId = entity.getEntryEntityId();
        if (entryEntityId != null) {
            stmt.bindLong(2, entryEntityId);
        }
 
        Long entryProfileEntityId = entity.getEntryProfileEntityId();
        if (entryProfileEntityId != null) {
            stmt.bindLong(3, entryProfileEntityId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinEntryEntityWithEntryProfileEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryEntityId = entity.getEntryEntityId();
        if (entryEntityId != null) {
            stmt.bindLong(2, entryEntityId);
        }
 
        Long entryProfileEntityId = entity.getEntryProfileEntityId();
        if (entryProfileEntityId != null) {
            stmt.bindLong(3, entryProfileEntityId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public JoinEntryEntityWithEntryProfileEntity readEntity(Cursor cursor, int offset) {
        JoinEntryEntityWithEntryProfileEntity entity = new JoinEntryEntityWithEntryProfileEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // entryEntityId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // entryProfileEntityId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinEntryEntityWithEntryProfileEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEntryEntityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setEntryProfileEntityId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(JoinEntryEntityWithEntryProfileEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(JoinEntryEntityWithEntryProfileEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(JoinEntryEntityWithEntryProfileEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
