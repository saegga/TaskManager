package sergei.taskmanager.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.generator.greendao.DaoSession;
import com.generator.greendao.Task;
import com.generator.greendao.TaskDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.Date;
import java.util.List;

import sergei.taskmanager.App;
import sergei.taskmanager.R;
import sergei.taskmanager.activity.TaskManagerActivity;
import sergei.taskmanager.adapters.AdapterTasksNew;

/**
 * Created by sergei on 28.08.2016.
 */
public class TaskManagerFragment extends Fragment implements ActionMode.Callback {

    private FloatingActionButton fabAddTask;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Task> taskList;
    private TextView emptyView;
    private DaoSession daoSession;
    private TaskDao taskDao;
    private static final String TAG = TaskManagerFragment.class.getName();
    private String mTextNewTask;
    private AdapterTasksNew mAdapterTaskNew;
    private ActionMode actionMode;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_layout_fragment, container, false);
        fabAddTask = (FloatingActionButton) view.findViewById(R.id.fab_add_new_task);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_new_task);
        emptyView = (TextView) view.findViewById(R.id.empty_view_tasks);
        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        setViewRecycler(taskList);

        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final EditText editTextTask = new EditText(getActivity());
                builder
                        .setTitle(getString(R.string.create_new_task_text))
                        .setView(R.layout.dialog_create_task)
                        .setView(editTextTask)
                        .setPositiveButton(getString(R.string.btn_create_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), editTextTask.getText().toString(), Toast.LENGTH_LONG).show();
                                mTextNewTask = editTextTask.getText().toString();
                                Task task = new Task();
                                task.setText_task(mTextNewTask);
                                task.setDate_task(getDate());
                                task.setIs_complete(false);
                                taskDao.insert(task);
                                taskList = taskDao.queryBuilder().where(TaskDao.Properties.Date_task.eq(getDate())).list();
                                ((AdapterTasksNew)recyclerView.getAdapter()).updateAdapterList(taskList);
                                updateViewVisible(taskList);
                                //mAdapterTaskNew.updateAdapterList(taskList);
                            }
                        })
                        .setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }});
                AppCompatDialog dialog = builder.create();
                dialog.show();
            }
        });

        recyclerView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d(TAG, "Long click");
                return false;
            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //// TODO: 30.08.2016 Добавить EventBus
        daoSession = ((App) getActivity().getApplication()).getDaoSession();
        taskDao = daoSession.getTaskDao();
       // taskDao.deleteAll();
        taskList = taskDao.loadAll();
        taskList.add(new Task(0L, "text", "2014-16-13", false));
        //updateAdapter();
    }

    /* return Date format is: 2016-03-21 */
    public String getDate(){
        return DateFormat.format("yyyy-MM-dd", new Date()).toString();
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    public void setViewRecycler(List<Task> taskList){
        mAdapterTaskNew = new AdapterTasksNew(getContext(), taskList);
        if(mAdapterTaskNew.getItemCount() == 0){
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        recyclerView.setAdapter(mAdapterTaskNew);
    }
    public void updateViewVisible(List<Task> taskList){
        if(taskList.size() == 0){
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    private class RecyclerViewSelectListener implements View.OnLongClickListener{

        @Override
        public boolean onLongClick(View v) {


            return false;
        }
    }
}

//// TODO: 01.09.2016 Можно ли объеденить методы updateViewVisible и setViewRecycler
