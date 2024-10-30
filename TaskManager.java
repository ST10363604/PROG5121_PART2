package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addTasks(int numTasks) {
        for (int i = 0; i < numTasks; i++) {
            System.out.println("Enter details for Task " + (i + 1) + ":");

            System.out.print("Task Name: ");
            String taskName = scanner.nextLine();

            System.out.print("Task Description: ");
            String taskDescription = scanner.nextLine();

            System.out.print("Developer Details: ");
            String developerDetails = scanner.nextLine();

            System.out.print("Task Duration (in hours): ");
            int taskDuration = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Choose status
            System.out.println("Select Task Status:");
            System.out.println("1) To Do");
            System.out.println("2) Done");
            System.out.println("3) Doing");
            int statusOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String taskStatus;
            taskStatus = switch (statusOption) {
                case 1 -> "To Do";
                case 2 -> "Done";
                case 3 -> "Doing";
                default -> "To Do";
            };

            Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, i, taskStatus);
            if (task.checkTaskDescription()) {
                System.out.println("Task successfully captured");
                tasks.add(task);
                task.printTaskDetails();
            } else {
                System.out.println("Please enter a task description of less than 50 characters");
            }
        }

        System.out.println("Total Duration for all tasks: " + returnTotalHours() + " hours");
    }

    // Calculate and return total duration
    public int returnTotalHours() {
        int totalDuration = 0;
        for (Task task : tasks) {
            totalDuration += task.getTaskDuration();
        }
        return totalDuration;
    }
}
