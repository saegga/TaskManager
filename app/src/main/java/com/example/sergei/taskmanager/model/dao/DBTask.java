package com.example.sergei.taskmanager.model.dao;

import org.greenrobot.greendao.DaoException;

/**
 * Created by sergei on 28.08.2016.
 */

public class DBTask {
    private Long idTask;
    private String textTask;
    private String dateTask;
    private boolean isComplete = false;

    private transient DaoSession daoSession;
    private transient DBTaskDao taskDao;

    public DBTask() {
    }

    public DBTask(Long idTask, String textTask, String dateTask, boolean isComplete) {
        this.idTask = idTask;
        this.textTask = textTask;
        this.dateTask = dateTask;
        this.isComplete = isComplete;
    }

    public DBTask(String textTask, String dateTask, boolean isComplete) {
        this.textTask = textTask;
        this.dateTask = dateTask;
        this.isComplete = isComplete;
    }
    public void __setDaoSession(DaoSession daoSession){
        this.daoSession = daoSession;
        taskDao = daoSession != null ? daoSession.getDBTaskDao() : null;
    }

    public void delete(){
        if(taskDao == null){
            throw new DaoException("Entety is detached from DAO context");
        }
        taskDao.delete(this);
    }
    public void update(){
        if(taskDao == null){
           throw new DaoException("Entety is detached from DAO context");
        }
        taskDao.update(this);
    }
    public void refresh(){
        if(taskDao == null){
            throw new DaoException("Entety is detached from DAO context");
        }
        taskDao.refresh(this);
    }
    public void insert(){
        if(taskDao == null){
            throw new DaoException("Entety is detached from DAO context");
        }
        taskDao.insert(this);
    }

    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public String getDateTask() {
        return dateTask;
    }

    public void setDateTask(String dateTask) {
        this.dateTask = dateTask;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
