package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

public class Task {
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskId;
    private final int taskNumber;
    private final String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskNumber, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskStatus = taskStatus;
        this.taskId = createTaskID();
    }

    // Method to check if task description is within 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create Task ID
    private String createTaskID() {
        String namePart = taskName.substring(0, 2).toUpperCase();
        String devPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return namePart + ":" + taskNumber + ":" + devPart;
    }

    // Method to print full task details
    public String printTaskDetails() {
        String taskDetails = "Task Status: " + taskStatus + "\n" +
                             "Developer Details: " + developerDetails + "\n" +
                             "Task Number: " + taskNumber + "\n" +
                             "Task Name: " + taskName + "\n" +
                             "Task Description: " + taskDescription + "\n" +
                             "Task ID: " + taskId + "\n" +
                             "Duration: " + taskDuration + " hours";
        
        JOptionPane.showMessageDialog(null, taskDetails, "Task Details", JOptionPane.INFORMATION_MESSAGE);
        return taskDetails;
    }

    // Getters
    public String getTaskId() { return taskId; }
    public int getTaskDuration() { return taskDuration; }
}
