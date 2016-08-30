package sergei.taskmanager;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.generator.greendao.DaoMaster;
import com.generator.greendao.DaoSession;

/**
 * Created by sergei on 30.08.2016.
 */

public class App extends Application {

    DaoMaster.DevOpenHelper openHelper;
    SQLiteDatabase database;
    DaoMaster daoMaster;
    DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        setupDataBase();
    }

    private void setupDataBase(){

        openHelper = new DaoMaster.DevOpenHelper(this, "TASK", null);
        database = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
    public SQLiteDatabase getDataBase(){
        return database;
    }
}
