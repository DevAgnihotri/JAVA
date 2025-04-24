import java.util.Scanner;
import java.util.Locale.Category;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String s[]) {
        try {
            Scanner sc = new Scanner(System.in);

            ArrayList<Task> todolist = new ArrayList<Task>();

            while (true) {
                System.out.println(
                        "Press 1 to add a task " +
                                "\n2 to view all the tasks" +
                                "\n3 to change status of tasks" +
                                "\n4 to delete a task " +
                                "\nAny other key to exit");

                String userAction = sc.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter the task");
                    String taskstr = sc.nextLine();

                    // Prompt the user to enter the priority of the task
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High");
                    int priority = Integer.parseInt(sc.nextLine());

                    // Validate priority input; set to 1 if invalid
                    priority = priority > 3 ? 1 : priority;

                    // Add the task with the given priority to the to-do list
                    todolist.add(new Task(taskstr, priority));
                    System.out.println("The task has been added to the list");

                }

                // Option 2: View all tasks in the to-do list
                else if (userAction.equals("2")) {
                    // Use forEach to print each task in the to-do list
                    todolist.forEach(task -> System.out.println(task));
                }

                // Option 3:
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the index of the task to change its status
                    System.out.println("Enter the index of the status you want to change");
                    int chgIdx = Integer.parseInt(sc.nextLine());

                    // Check if the index is valid
                    if (chgIdx > (todolist.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new status of the task
                        System.out.println("Enter the new status of the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = sc.nextLine();

                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todolist.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todolist.get(chgIdx).setStatus(Task.COMPLETED);
                        }
                    }
                    // Notify the user that the task status has been updated
                    System.out.println("The task status has been updated.");
                } else if (userAction.equals("4")) {
                    // Prompt the user to enter the index of the task to delete
                    System.out.println("Enter the index of the task you want to delete");
                    int rmvIdx = Integer.parseInt(sc.nextLine());

                    // Check if the index is valid
                    if (rmvIdx > (todolist.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Remove the task from the list
                        todolist.remove(rmvIdx);
                        System.out.println("Task has been removed from the list");
                    }
                } else {
                    // Notify the user of invalid input and continue the loop
                    System.out.println("Invalid input. Please try again.");
                }
            }
            sc.close();
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
