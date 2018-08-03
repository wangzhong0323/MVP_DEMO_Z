package com.example.mvpdemo0602.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.mvpdemo0602.bean.Persion;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "user_persion".
*/
public class PersionDao extends AbstractDao<Persion, Long> {

    public static final String TABLENAME = "user_persion";

    /**
     * Properties of entity Persion.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property P_id = new Property(0, Long.class, "p_id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property Num = new Property(3, String.class, "num", false, "NUM");
    }


    public PersionDao(DaoConfig config) {
        super(config);
    }
    
    public PersionDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"user_persion\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: p_id
                "\"NAME\" TEXT," + // 1: name
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"NUM\" TEXT);"); // 3: num
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"user_persion\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Persion entity) {
        stmt.clearBindings();
 
        Long p_id = entity.getP_id();
        if (p_id != null) {
            stmt.bindLong(1, p_id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Persion entity) {
        stmt.clearBindings();
 
        Long p_id = entity.getP_id();
        if (p_id != null) {
            stmt.bindLong(1, p_id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Persion readEntity(Cursor cursor, int offset) {
        Persion entity = new Persion();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Persion entity, int offset) {
        entity.setP_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setNum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Persion entity, long rowId) {
        entity.setP_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Persion entity) {
        if(entity != null) {
            return entity.getP_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Persion entity) {
        return entity.getP_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
