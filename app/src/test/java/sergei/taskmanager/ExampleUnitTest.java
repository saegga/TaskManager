package sergei.taskmanager;

import android.app.Application;

import com.generator.greendao.DaoSession;
import com.generator.greendao.Task;
import com.generator.greendao.TaskDao;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void daoTest(){
//        App app = new App();
//        DaoSession session = app.getDaoSession();
//        TaskDao taskDao = session.getTaskDao();
//        List<Task> tasks = taskDao.loadAll();
//        assertNull(tasks);
    }
}