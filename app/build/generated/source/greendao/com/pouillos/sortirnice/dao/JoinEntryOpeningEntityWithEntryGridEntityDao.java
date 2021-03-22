package com.pouillos.sortirnice.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.pouillos.sortirnice.entities.entry.join.JoinEntryOpeningEntityWithEntryGridEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOIN_ENTRY_OPENING_ENTITY_WITH_ENTRY_GRID_ENTITY".
*/
public class JoinEntryOpeningEntityWithEntryGridEntityDao extends AbstractDao<JoinEntryOpeningEntityWithEntryGridEntity, Long> {

    public static final String TABLENAME = "JOIN_ENTRY_OPENING_ENTITY_WITH_ENTRY_GRID_ENTITY";

    /**
     * Properties of entity JoinEntryOpeningEntityWithEntryGridEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EntryOpeningEntityId = new Property(1, Long.class, "entryOpeningEntityId", false, "ENTRY_OPENING_ENTITY_ID");
        public final static Property EntryGridEntityId = new Property(2, Long.class, "entryGridEntityId", false, "ENTRY_GRID_ENTITY_ID");
    }


    public JoinEntryOpeningEntityWithEntryGridEntityDao(DaoConfig config) {
        super(config);
    }
    
    public JoinEntryOpeningEntityWithEntryGridEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOIN_ENTRY_OPENING_ENTITY_WITH_ENTRY_GRID_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ENTRY_OPENING_ENTITY_ID\" INTEGER," + // 1: entryOpeningEntityId
                "\"ENTRY_GRID_ENTITY_ID\" INTEGER);"); // 2: entryGridEntityId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOIN_ENTRY_OPENING_ENTITY_WITH_ENTRY_GRID_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, JoinEntryOpeningEntityWithEntryGridEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryOpeningEntityId = entity.getEntryOpeningEntityId();
        if (entryOpeningEntityId != null) {
            stmt.bindLong(2, entryOpeningEntityId);
        }
 
        Long entryGridEntityId = entity.getEntryGridEntityId();
        if (entryGridEntityId != null) {
            stmt.bindLong(3, entryGridEntityId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, JoinEntryOpeningEntityWithEntryGridEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long entryOpeningEntityId = entity.getEntryOpeningEntityId();
        if (entryOpeningEntityId != null) {
            stmt.bindLong(2, entryOpeningEntityId);
        }
 
        Long entryGridEntityId = entity.getEntryGridEntityId();
        if (entryGridEntityId != null) {
            stmt.bindLong(3, entryGridEntityId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public JoinEntryOpeningEntityWithEntryGridEntity readEntity(Cursor cursor, int offset) {
        JoinEntryOpeningEntityWithEntryGridEntity entity = new JoinEntryOpeningEntityWithEntryGridEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // entryOpeningEntityId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // entryGridEntityId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, JoinEntryOpeningEntityWithEntryGridEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEntryOpeningEntityId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setEntryGridEntityId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(JoinEntryOpeningEntityWithEntryGridEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(JoinEntryOpeningEntityWithEntryGridEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(JoinEntryOpeningEntityWithEntryGridEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
