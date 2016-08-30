package com.example.sergei.taskmanager.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/**
 * Created by sergei on 30.08.2016.
 */
public class DaoMaster extends AbstractDaoMaster {

    public static final int VERSION = 1;

    public static void createAllTAbles(SQLiteDatabase db, boolean ifNotExists){


    }
    public abstract class OpenHelper extends SQLiteOpenHelper{

        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDao", "create table with schema version :" + VERSION);

        }
    }
    public DaoMaster(Database db, int schemaVersion) {
        super(db, schemaVersion);
    }

    @Override
    public AbstractDaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    @Override
    public AbstractDaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
}
