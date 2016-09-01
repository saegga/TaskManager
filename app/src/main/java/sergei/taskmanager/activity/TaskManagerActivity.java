package sergei.taskmanager.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import sergei.taskmanager.R;
import sergei.taskmanager.fragment.TaskManagerFragment;

/**
 * Created by sergei on 28.08.2016.
 */
public class TaskManagerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.task_toolbar);
        toolbar.setTitle(getString(R.string.tasks));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite, getTheme()));
        }else{
            toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        }
        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        setSupportActionBar(toolbar);
        initDrawer();
        initFragment();

    }
    public void initDrawer(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation_list);
        navigationView.setNavigationItemSelectedListener(new NavigationListener());
    }
    public void initFragment(){
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.task_fragment_container);
        if(fragment == null){
            fragment = new TaskManagerFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.task_fragment_container, fragment)
                    .commit();
        }
//        TaskManagerFragment taskManagerFragment;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.openDrawer(GravityCompat.START);
                    return true;
                }else{
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    private class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            return false;
        }
    }
}
