package com.example.work_well;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    private String message;
    @SerializedName("task")
    private List<Task> tasks;

    public Results(String message, List<Task> tasks) {
        this.message = message;
        this.tasks = tasks;
    }

    public String getMessage() {
        return message;
    }

//public Results(List<Task> tasks) {
      //  this.tasks = tasks;
   // }

    public List<Task> getTasks() {
        return tasks;
    }
}
