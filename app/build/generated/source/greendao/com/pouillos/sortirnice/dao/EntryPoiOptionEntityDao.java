package com.pouillos.sortirnice.dao;

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

import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPoiOptionEntity;

import com.pouillos.sortirnice.entities.entry.detail.EntryPoiOptionEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ENTRY_POI_OPTION_ENTITY".
*/
public class EntryPoiOptionEntityDao extends AbstractDao<EntryPoiOptionEntity, Long> {

    public static final String TABLENAME = "ENTRY_POI_OPTION_ENTITY";

    /**
     * Properties of entity EntryPoiOptionEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Value = new Property(1, String.class, "value", false, "VALUE");
    }

    private Query<EntryPoiOptionEntity> entryEntity_ListPoiOptionsQuery;

    public EntryPoiOptionEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EntryPoiOptionEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ENTRY_POI_OPTION_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"VALUE\" TEXT);"); // 1: value
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ENTRY_POI_OPTION_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EntryPoiOptionEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String value = entity.getValue();
        if (value != null) {
            stmt.bindString(2, value);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, EntryPoiOptionEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String value = entity.getValue();
        if (value != null) {
            stmt.bindString(2, value);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public EntryPoiOptionEntity readEntity(Cursor cursor, int offset) {
        EntryPoiOptionEntity entity = new EntryPoiOptionEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // value
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EntryPoiOptionEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setValue(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EntryPoiOptionEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EntryPoiOptionEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EntryPoiOptionEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listPoiOptions" to-many relationship of EntryEntity. */
    public List<EntryPoiOptionEntity> _queryEntryEntity_ListPoiOptions(Long entryEntityId) {
        synchronized (this) {
            if (entryEntity_ListPoiOptionsQuery == null) {
                QueryBuilder<EntryPoiOptionEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEntryEntityWithEntryPoiOptionEntity.class, JoinEntryEntityWithEntryPoiOptionEntityDao.Properties.EntryPoiOptionEntityId)
                    .where(JoinEntryEntityWithEntryPoiOptionEntityDao.Properties.EntryEntityId.eq(entryEntityId));
                entryEntity_ListPoiOptionsQuery = queryBuilder.build();
            }
        }
        Query<EntryPoiOptionEntity> query = entryEntity_ListPoiOptionsQuery.forCurrentThread();
        query.setParameter(0, entryEntityId);
        return query.list();
    }

}