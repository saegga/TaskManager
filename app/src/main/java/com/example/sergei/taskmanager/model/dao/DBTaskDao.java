package com.example.sergei.taskmanager.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/**
 * Created by sergei on 30.08.2016.
 */
public class DBTaskDao extends AbstractDao<DBTask, Long>{

    private DaoSession daoSession;
    public static final String TABLENAME = "DBTASK";

    public static class Properties{
        public static final Property Id = new Property(0, Long.class, "id", true, "id_task");
        public static final Property TextTask = new Property(1, String.class, "textTask", false, "text_task");
        public static final Property DateTask = new Property(2, String.class, "dateTask", false, "date_task");
        public static final Property IsComplete = new Property(3, Boolean.class, "complete", false, "complete_task");
    }

    public DBTaskDao(DaoConfig config) {
        super(config);
    }

    public DBTaskDao(DaoConfig config, AbstractDaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTAble(Database db, boolean ifNotExists){

        String constraing = ifNotExists ? "IF NOT EXISTS" : "";
        db.execSQL("CREATE TABLE " + constraing + "\" DBTASK \" (" +
                "\" + id_task\" INTEGER PRIMARY_KEY AUTOINCREMENT ," +
                "\" +  text_task\" TEXT NOT NULL " +
                "\" +  date_task\" TEXT NOT NULL" +
                "\" +  complete_task\" BOOLEAN NOT NULL" +
                ");");
    }
    public static void dropTable(Database db, boolean ifNotExists){
        String sql = "DROP TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\" DBTASK \"";
        db.execSQL(sql);
    }

    @Override
    protected DBTask readEntity(Cursor cursor, int offset) {
        return null;
    }

    @Override
    protected Long readKey(Cursor cursor, int offset) {
        return null;
    }

    @Override
    protected void readEntity(Cursor cursor, DBTask entity, int offset) {

    }

    @Override
    protected void bindValues(DatabaseStatement stmt, DBTask entity) {


    }

    @Override
    protected void bindValues(SQLiteStatement stmt, DBTask entity) {
        stmt.clearBindings();
        Long id = entity.getIdTask();
        stmt.bindLong(1, id);
        stmt.bindString(2, entity.getTextTask());
        stmt.bindString(3, entity.getDateTask());
        stmt.bindString(4, String.valueOf(entity.isComplete()));
    }

    @Override
    protected Long updateKeyAfterInsert(DBTask entity, long rowId) {
        return null;
    }

    @Override
    protected Long getKey(DBTask entity) {
        return null;
    }

    @Override
    protected boolean hasKey(DBTask entity) {
        return false;
    }

    @Override
    protected boolean isEntityUpdateable() {
        return false;
    }
}
