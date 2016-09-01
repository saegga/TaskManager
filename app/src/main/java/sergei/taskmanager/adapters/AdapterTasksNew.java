package sergei.taskmanager.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.generator.greendao.Task;
import java.util.List;

import sergei.taskmanager.R;

/**
 * Created by sergei on 31.08.2016.
 */
public class AdapterTasksNew extends RecyclerView.Adapter<AdapterTasksNew.ViewHolder> {

    private List<Task> tasks;

    public AdapterTasksNew(List<Task> tasks) {
        this.tasks = tasks;
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
    public void updateAdapterList(List<Task> tasks){
        this.tasks.clear();
        this.tasks.addAll(tasks);
        this.notifyDataSetChanged();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTask;
        public ViewHolder(View itemView) {
            super(itemView);
            textTask = (TextView) itemView.findViewById(R.id.text_new_task);
        }
    }
}
