package com.example.sergei.taskmanager.model.dao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

/**
 * Created by sergei on 30.08.2016.
 */
public class DaoSession extends AbstractDaoSession {

    private final DBTaskDao taskDao;
    private final DaoConfig taskDaoConfig;

//    public DaoSession(Database db) {
//        super(db);
//    }

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap) {
        super(db);
        taskDaoConfig = daoConfigMap.get(DBTaskDao.class).clone();
        taskDaoConfig.initIdentityScope(type);
        taskDao = new DBTaskDao(taskDaoConfig, this);
    }

    public DBTaskDao getDBTaskDao() {
        return taskDao;
    }
    public void clear(){
        taskDaoConfig.clearIdentityScope();
    }
}
