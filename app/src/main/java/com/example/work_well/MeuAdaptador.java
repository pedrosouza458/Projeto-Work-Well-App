package com.example.work_well;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class MeuAdaptador extends RecyclerView.Adapter<MeuAdaptador.ViewHolder> {
    List<com.example.work_well.Task> tasks;

    public MeuAdaptador(List<com.example.work_well.Task> tasks) {
        this.tasks = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView text;
        final TextView idImportance;
        final TextView created_at;
        final CheckBox checked;

        public ViewHolder(View view) {
            super(view);
            text = (TextView) view.findViewById(R.id.text);
            idImportance = (TextView) view.findViewById(R.id.idImportance);
            created_at = (TextView) view.findViewById(R.id.created_at);
            checked = (CheckBox) view.findViewById(R.id.checked);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tasks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.example.work_well.Task task = tasks.get(position);
        holder.text.setText(task.text);
        holder.created_at.setText("Criado em: " + task.created_at);
        if(task.idImportance == 1) {
            holder.idImportance.setText("Importância: " + task.idImportance + " (pouca)");
        }
        if(task.idImportance == 2) {
            holder.idImportance.setText("Importância: " + task.idImportance + " (média)");
        }
        if(task.idImportance == 3) {
            holder.idImportance.setText("Importância: " + task.idImportance + " (muita)");
        }
        if(Objects.equals(task.checked, "True")){
            Log.d("funcionou", task.checked);
            holder.checked.setChecked(true);
        }
    }



    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
