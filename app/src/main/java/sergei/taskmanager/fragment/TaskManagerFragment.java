package sergei.taskmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.generator.greendao.DaoSession;
import com.generator.greendao.Task;
import com.generator.greendao.TaskDao;

import java.util.List;

import sergei.taskmanager.App;
import sergei.taskmanager.R;
import sergei.taskmanager.adapters.AdapterTasksNew;

/**
 * Created by sergei on 28.08.2016.
 */
public class TaskManagerFragment extends Fragment {

    private FloatingActionButton fabAddTask;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Task> taskList;
    private TextView emptyView;
    private DaoSession daoSession;
    private TaskDao taskDao;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_layout_fragment, container, false);
        fabAddTask = (FloatingActionButton) view.findViewById(R.id.fab_add_new_task);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_new_task);
        emptyView = (TextView) view.findViewById(R.id.empty_view_tasks);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //// TODO: 30.08.2016 Добавить EventBus
        daoSession = ((App) getActivity().getApplication()).getDaoSession();
        taskDao = daoSession.getTaskDao();
        taskList = taskDao.loadAll();
        setViewRecycler(taskList);

    }
    public void setViewRecycler(List<Task> taskList){
        AdapterTasksNew adapterTasksNew = new AdapterTasksNew(taskList);
        if(adapterTasksNew.getItemCount() == 0){
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            recyclerView.setAdapter(adapterTasksNew);
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}
