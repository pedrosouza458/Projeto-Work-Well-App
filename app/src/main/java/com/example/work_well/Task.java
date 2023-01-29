package com.example.work_well;

import com.google.gson.annotations.SerializedName;

public class Task {
        @SerializedName("text")
        String text;
        int idImportance;
        String created_at;
        String checked;

        public Task(String text, int idImportance, String created_at, String checked) {
            this.text = text;
            this.idImportance = idImportance;
            this.created_at = created_at;
            this.checked = checked;
        }
    }
