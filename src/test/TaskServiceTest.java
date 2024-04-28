package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Task;
import main.TaskService;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        assertTrue(taskService.tasks.containsKey("1234567890"));
        assertEquals(task, taskService.tasks.get("1234567890"));
    }

    @Test
    public void testAddDuplicateTask() {
        Task task1 = new Task("1234567890", "Task Name", "Task Description");
        Task task2 = new Task("1234567890", "Another Task", "Another Description");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        taskService.addTask(task);
        taskService.deleteTask("1234567890");
        assertFalse(taskService.tasks.containsKey("1234567890"));
    }

    @Test
    public void testDeleteNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("1234567890"));
    }

}
