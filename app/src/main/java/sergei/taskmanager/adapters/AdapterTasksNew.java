package sergei.taskmanager.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.generator.greendao.Task;

import java.util.ArrayList;
import java.util.List;

import sergei.taskmanager.R;

/**
 * Created by sergei on 31.08.2016.
 */
public class AdapterTasksNew extends RecyclerView.Adapter<AdapterTasksNew.ViewHolder> {

    private List<Task> tasks;
    private static Context mContext;
    private SparseBooleanArray mSelectedItems;
    private View.OnLongClickListener mClickListener;
    //private boolean mVisibleCheckBox = false;

    public AdapterTasksNew(Context context, List<Task> tasks, View.OnLongClickListener clickListener) {
        this.tasks = tasks;
        this.mContext = context;
        this.mClickListener = clickListener;
        mSelectedItems = new SparseBooleanArray();
        //this.mVisibleCheckBox = visibleCheckBox;
    }
    public void toggleSelection(int position){
        if(mSelectedItems.get(position, false)){
            mSelectedItems.delete(position);
        }else{
            mSelectedItems.put(position, true);
        }
        notifyItemChanged(position);
    }
    public void clearSelections(){
        mSelectedItems.clear();
        notifyDataSetChanged();
    }
    public int getSelectedItemCount(){
        return mSelectedItems.size();
    }
    public List<Integer> getSelectedItems(){
        List<Integer> items = new ArrayList<>(mSelectedItems.size());
        for (int i = 0; i < mSelectedItems.size(); i++) {
            items.add(mSelectedItems.keyAt(i));
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
        holder.itemView.setOnLongClickListener(mClickListener);
        holder.itemView.setActivated(mSelectedItems.get(position, false));
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
