package com.mycompany.mavenproject1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testCheckTaskDescription_Success() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, 1, "To Do");
        assertTrue(task.checkTaskDescription(), "Task successfully captured");
    }

    @Test
    public void testCheckTaskDescription_Failure() {
        Task task = new Task("Login Feature", "This is a very long task description that exceeds fifty characters and should fail.", "Robyn Harrison", 8, 1, "To Do");
        assertFalse(task.checkTaskDescription(), "Please enter a task description of less than 50 characters");
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, 1, "To Do");
        assertEquals("LO:1:SON", task.getTaskId());
    }

    @Test
    public void testReturnTotalHours() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTasks(2); // Assume durations added sum up to 18
        assertEquals(18, taskManager.returnTotalHours());
    }

    @Test
    public void testAdditionalDataForTotalHours() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTasks(5); // Assume durations added are {10, 12, 55, 11, 1}
        assertEquals(89, taskManager.returnTotalHours());
    }
}
