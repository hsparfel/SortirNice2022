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

import com.pouillcorp.sortirnice.entities.entry.join.JoinEntryEntityWithEntrySpaceEntity;

import com.pouillcorp.sortirnice.entities.entry.detail.EntrySpaceEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ENTRY_SPACE_ENTITY".
*/
public class EntrySpaceEntityDao extends AbstractDao<EntrySpaceEntity, Long> {

    public static final String TABLENAME = "ENTRY_SPACE_ENTITY";

    /**
     * Properties of entity EntrySpaceEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property CapacityTheater = new Property(2, int.class, "capacityTheater", false, "CAPACITY_THEATER");
        public final static Property CapacityClassroom = new Property(3, int.class, "capacityClassroom", false, "CAPACITY_CLASSROOM");
        public final static Property CapacityU = new Property(4, int.class, "capacityU", false, "CAPACITY_U");
        public final static Property CapacityCocktail = new Property(5, int.class, "capacityCocktail", false, "CAPACITY_COCKTAIL");
        public final static Property CapacitySeatedmeal = new Property(6, int.class, "capacitySeatedmeal", false, "CAPACITY_SEATEDMEAL");
        public final static Property CeilingHeight = new Property(7, int.class, "ceilingHeight", false, "CEILING_HEIGHT");
        public final static Property IsNaturalLight = new Property(8, int.class, "isNaturalLight", false, "IS_NATURAL_LIGHT");
        public final static Property Area = new Property(9, int.class, "area", false, "AREA");
    }

    private Query<EntrySpaceEntity> entryEntity_ListSpacesQuery;

    public EntrySpaceEntityDao(DaoConfig config) {
        super(config);
    }
    
    public EntrySpaceEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ENTRY_SPACE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"CAPACITY_THEATER\" INTEGER NOT NULL ," + // 2: capacityTheater
                "\"CAPACITY_CLASSROOM\" INTEGER NOT NULL ," + // 3: capacityClassroom
                "\"CAPACITY_U\" INTEGER NOT NULL ," + // 4: capacityU
                "\"CAPACITY_COCKTAIL\" INTEGER NOT NULL ," + // 5: capacityCocktail
                "\"CAPACITY_SEATEDMEAL\" INTEGER NOT NULL ," + // 6: capacitySeatedmeal
                "\"CEILING_HEIGHT\" INTEGER NOT NULL ," + // 7: ceilingHeight
                "\"IS_NATURAL_LIGHT\" INTEGER NOT NULL ," + // 8: isNaturalLight
                "\"AREA\" INTEGER NOT NULL );"); // 9: area
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ENTRY_SPACE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, EntrySpaceEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getCapacityTheater());
        stmt.bindLong(4, entity.getCapacityClassroom());
        stmt.bindLong(5, entity.getCapacityU());
        stmt.bindLong(6, entity.getCapacityCocktail());
        stmt.bindLong(7, entity.getCapacitySeatedmeal());
        stmt.bindLong(8, entity.getCeilingHeight());
        stmt.bindLong(9, entity.getIsNaturalLight());
        stmt.bindLong(10, entity.getArea());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, EntrySpaceEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getCapacityTheater());
        stmt.bindLong(4, entity.getCapacityClassroom());
        stmt.bindLong(5, entity.getCapacityU());
        stmt.bindLong(6, entity.getCapacityCocktail());
        stmt.bindLong(7, entity.getCapacitySeatedmeal());
        stmt.bindLong(8, entity.getCeilingHeight());
        stmt.bindLong(9, entity.getIsNaturalLight());
        stmt.bindLong(10, entity.getArea());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public EntrySpaceEntity readEntity(Cursor cursor, int offset) {
        EntrySpaceEntity entity = new EntrySpaceEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // capacityTheater
            cursor.getInt(offset + 3), // capacityClassroom
            cursor.getInt(offset + 4), // capacityU
            cursor.getInt(offset + 5), // capacityCocktail
            cursor.getInt(offset + 6), // capacitySeatedmeal
            cursor.getInt(offset + 7), // ceilingHeight
            cursor.getInt(offset + 8), // isNaturalLight
            cursor.getInt(offset + 9) // area
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, EntrySpaceEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCapacityTheater(cursor.getInt(offset + 2));
        entity.setCapacityClassroom(cursor.getInt(offset + 3));
        entity.setCapacityU(cursor.getInt(offset + 4));
        entity.setCapacityCocktail(cursor.getInt(offset + 5));
        entity.setCapacitySeatedmeal(cursor.getInt(offset + 6));
        entity.setCeilingHeight(cursor.getInt(offset + 7));
        entity.setIsNaturalLight(cursor.getInt(offset + 8));
        entity.setArea(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(EntrySpaceEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(EntrySpaceEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(EntrySpaceEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "listSpaces" to-many relationship of EntryEntity. */
    public List<EntrySpaceEntity> _queryEntryEntity_ListSpaces(Long entryEntityId) {
        synchronized (this) {
            if (entryEntity_ListSpacesQuery == null) {
                QueryBuilder<EntrySpaceEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinEntryEntityWithEntrySpaceEntity.class, JoinEntryEntityWithEntrySpaceEntityDao.Properties.EntrySpaceEntityId)
                    .where(JoinEntryEntityWithEntrySpaceEntityDao.Properties.EntryEntityId.eq(entryEntityId));
                entryEntity_ListSpacesQuery = queryBuilder.build();
            }
        }
        Query<EntrySpaceEntity> query = entryEntity_ListSpacesQuery.forCurrentThread();
        query.setParameter(0, entryEntityId);
        return query.list();
    }

}
