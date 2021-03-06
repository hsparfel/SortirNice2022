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

import com.pouillcorp.sortirnice.entities.event.join.JoinEvenementEntityWithEvenementCategoryEntity;

import com.pouillcorp.sortirnice.entities.event.detail.EvenementCategoryEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EVENEMENT_CATEGORY_ENTITY".
*/
public class EvenementCategoryEntityDao extends AbstractDao<EvenementCategoryEntity, Long> {

    public static final String TABLENAME = "EVENEMENT_CATEGORY_ENTITY";

    /**
     * Properties of entity EvenementCategoryEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Value = new Property(1, String.class, "value", false, "VALUE");
    }

    private Query<EvenementCategoryEntity> evenementEntity_ListCategoriesQuery;

    public EvenementCategoryEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EvenementCategoryEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EVENEMENT_CATEGORY_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"VALUE\" TEXT);"); // 1: value
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EVENEMENT_CATEGORY_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EvenementCategoryEntity entity) {
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
    protected final void bindValues(SQLiteStatement stmt, EvenementCategoryEntity entity) {
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
    public EvenementCategoryEntity readEntity(Cursor cursor, int offset) {
        EvenementCategoryEntity entity = new EvenementCategoryEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // value
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EvenementCategoryEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setValue(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EvenementCategoryEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EvenementCategoryEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EvenementCategoryEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listCategories" to-many relationship of EvenementEntity. */
    public List<EvenementCategoryEntity> _queryEvenementEntity_ListCategories(Long evenementEntityId) {
        synchronized (this) {
            if (evenementEntity_ListCategoriesQuery == null) {
                QueryBuilder<EvenementCategoryEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEvenementEntityWithEvenementCategoryEntity.class, JoinEvenementEntityWithEvenementCategoryEntityDao.Properties.EvenementCategoryEntityId)
                    .where(JoinEvenementEntityWithEvenementCategoryEntityDao.Properties.EvenementEntityId.eq(evenementEntityId));
                evenementEntity_ListCategoriesQuery = queryBuilder.build();
            }
        }
        Query<EvenementCategoryEntity> query = evenementEntity_ListCategoriesQuery.forCurrentThread();
        query.setParameter(0, evenementEntityId);
        return query.list();
    }

}
