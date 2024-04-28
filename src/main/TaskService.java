package main;

import java.util.HashMap;
import java.util.Map;

public class TaskService { // TaskService class
    public final Map<String, Task> tasks = new HashMap<>(); // HashMap to store contacts 

    public void addTask(Task task) { // addTask method to add contact to HashMap with unique ID
        String taskId = task.getTaskId();
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " already exists");
        }
        tasks.put(taskId, task);
    }

    public void deleteTask(String taskId) { // deleteTask to delete task identified by the unique ID
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String name, String description) { // updateTask method to update task's name and desc identified by the unique ID
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        if (name != null) {
            task.setName(name);
        }
        if (description != null) {
            task.setDescription(description);
        }
    }

    public void updateTaskName(String taskId, String name, String description) { // updateTask method to update task's name and desc identified by the unique ID
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        if (name != null) {
            task.setName(name);
        }
    }

    public void updateTaskDesc(String taskId, String name, String description) { // updateTask method to update task's name and desc identified by the unique ID
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        
        if (description != null) {
            task.setDescription(description);
        }
    }

   
}
