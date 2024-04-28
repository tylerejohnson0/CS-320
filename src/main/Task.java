package main;

public class Task { // Task class
    private final String taskId; //  unique  taskId string that is non updatable
    private String name; // name string
    private String description; // decription string 

    // constructor
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) { // taskId must not be null or have a length greater than 10
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (name == null || name.length() > 20) { // name must not be null or have a length greater than 20
            throw new IllegalArgumentException("Invalid name");
        }
        if (description == null || description.length() > 50) { // description must not be null or have a length greater than 50
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // setters
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

}
