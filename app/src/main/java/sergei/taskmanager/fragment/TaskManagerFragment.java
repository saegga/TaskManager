package sergei.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generator.greendao.DaoSession;
import com.generator.greendao.TaskDao;

import sergei.taskmanager.App;
import sergei.taskmanager.R;

/**
 * Created by sergei on 28.08.2016.
 */
public class TaskManagerFragment extends Fragment {

    private FloatingActionButton fabAddTask;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_layout_fragment, container, false);
        fabAddTask = (FloatingActionButton) view.findViewById(R.id.fab_add_new_task);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //// TODO: 30.08.2016 Добавить EventBus
//        session = ((App) getActivity().getApplication()).getDaoSession();
//        taskDao = session.getTaskDao();
//        taskDao.loadAll();

    }
}
