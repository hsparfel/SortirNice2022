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

import com.pouillos.sortirnice.entities.entry.join.JoinEntryEntityWithEntryPublicationEntity;

import com.pouillos.sortirnice.entities.entry.detail.EntryPublicationEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ENTRY_PUBLICATION_ENTITY".
*/
public class EntryPublicationEntityDao extends AbstractDao<EntryPublicationEntity, Long> {

    public static final String TABLENAME = "ENTRY_PUBLICATION_ENTITY";

    /**
     * Properties of entity EntryPublicationEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Value = new Property(1, String.class, "value", false, "VALUE");
    }

    private Query<EntryPublicationEntity> entryEntity_ListPublicationsQuery;

    public EntryPublicationEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EntryPublicationEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ENTRY_PUBLICATION_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"VALUE\" TEXT);"); // 1: value
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ENTRY_PUBLICATION_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EntryPublicationEntity entity) {
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
    protected final void bindValues(SQLiteStatement stmt, EntryPublicationEntity entity) {
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
    public EntryPublicationEntity readEntity(Cursor cursor, int offset) {
        EntryPublicationEntity entity = new EntryPublicationEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // value
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EntryPublicationEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setValue(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EntryPublicationEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EntryPublicationEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EntryPublicationEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listPublications" to-many relationship of EntryEntity. */
    public List<EntryPublicationEntity> _queryEntryEntity_ListPublications(Long entryEntityId) {
        synchronized (this) {
            if (entryEntity_ListPublicationsQuery == null) {
                QueryBuilder<EntryPublicationEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEntryEntityWithEntryPublicationEntity.class, JoinEntryEntityWithEntryPublicationEntityDao.Properties.EntryPublicationEntityId)
                    .where(JoinEntryEntityWithEntryPublicationEntityDao.Properties.EntryEntityId.eq(entryEntityId));
                entryEntity_ListPublicationsQuery = queryBuilder.build();
            }
        }
        Query<EntryPublicationEntity> query = entryEntity_ListPublicationsQuery.forCurrentThread();
        query.setParameter(0, entryEntityId);
        return query.list();
    }

}
