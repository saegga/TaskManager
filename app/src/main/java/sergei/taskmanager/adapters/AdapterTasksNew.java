package sergei.taskmanager.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.TextView;

import com.generator.greendao.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import sergei.taskmanager.R;

/**
 * Created by sergei on 31.08.2016.
 */
public class AdapterTasksNew extends RecyclerView.Adapter<AdapterTasksNew.ViewHolder> {

    private List<Task> tasks;
    private static Context mContext;
    private SparseBooleanArray selectedItems;
    //private boolean mVisibleCheckBox = false;

    public AdapterTasksNew(Context context, List<Task> tasks) {
        this.tasks = tasks;
        this.mContext = context;
        //this.mVisibleCheckBox = visibleCheckBox;
    }
    public void toggleSelection(int position){
        if(selectedItems.get(position, false)){
            selectedItems.delete(position);
        }else{
            selectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }
    public void clearSelections(){
        selectedItems.clear();
        notifyDataSetChanged();
    }
    public int getSelectedItemCount(){
        return selectedItems.size();
    }
    public List<Integer> getSelectedItems(){
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

    @Override
    public AdapterTasksNew.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_new_task_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterTasksNew.ViewHolder holder, int position) {
        holder.textTask.setText(tasks.get(position).getText_task());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void updateAdapterList(List<Task> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
        this.notifyDataSetChanged();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTask;
        CheckBox checkBoxNewTask;

        public ViewHolder(View itemView) {
            super(itemView);
            textTask = (TextView) itemView.findViewById(R.id.text_new_task);
            checkBoxNewTask = (CheckBox) itemView.findViewById(R.id.check_view_new_task);
            //checkBoxNewTask.setVisibility(visibleCheckbox ? View.VISIBLE : View.INVISIBLE);


        }
    }
}
