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

import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntryServiceEntity;

import com.pouillcorp.sortirnice.entities.entry.detail.EntryServiceEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ENTRY_SERVICE_ENTITY".
*/
public class EntryServiceEntityDao extends AbstractDao<EntryServiceEntity, Long> {

    public static final String TABLENAME = "ENTRY_SERVICE_ENTITY";

    /**
     * Properties of entity EntryServiceEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Value = new Property(1, String.class, "value", false, "VALUE");
    }

    private Query<EntryServiceEntity> entryEntity_ListServicesQuery;

    public EntryServiceEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EntryServiceEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ENTRY_SERVICE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"VALUE\" TEXT);"); // 1: value
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ENTRY_SERVICE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EntryServiceEntity entity) {
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
    protected final void bindValues(SQLiteStatement stmt, EntryServiceEntity entity) {
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
    public EntryServiceEntity readEntity(Cursor cursor, int offset) {
        EntryServiceEntity entity = new EntryServiceEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // value
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EntryServiceEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setValue(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EntryServiceEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EntryServiceEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EntryServiceEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listServices" to-many relationship of EntryEntity. */
    public List<EntryServiceEntity> _queryEntryEntity_ListServices(Long entryEntityId) {
        synchronized (this) {
            if (entryEntity_ListServicesQuery == null) {
                QueryBuilder<EntryServiceEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEntryEntityWithEntryServiceEntity.class, JoinEntryEntityWithEntryServiceEntityDao.Properties.EntryServiceEntityId)
                    .where(JoinEntryEntityWithEntryServiceEntityDao.Properties.EntryEntityId.eq(entryEntityId));
                entryEntity_ListServicesQuery = queryBuilder.build();
            }
        }
        Query<EntryServiceEntity> query = entryEntity_ListServicesQuery.forCurrentThread();
        query.setParameter(0, entryEntityId);
        return query.list();
    }

}