package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.Task;

public class TaskTest {

    @Test
    public void testValidTask() {
        Task task = new Task("1234567890", "Task Name", "Task Desc");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Desc", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task Name", "Task Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task Name", "Task Description"));
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", null, "Task Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("1234567890", "Task Name That Is Too Long", "Task Description"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Task Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("1234567890", "Task Name",
                "Task Description That Is Too Long And Exceeds The Maximum Allowed Length"));
    }

    @Test
    public void testUpdateName() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setName("New Task Name");
        assertEquals("New Task Name", task.getName());
    }

    @Test
    public void testUpdateDescription() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setDescription("New Task Description");
        assertEquals("New Task Description", task.getDescription());
    }
}
