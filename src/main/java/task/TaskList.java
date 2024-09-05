package task;

import java.util.ArrayList;


/**
 * Represents a list of tasks.
 * <p>
 * The {@code TaskList} class manages a collection of {@link Task} objects, allowing
 * for tasks to be added, deleted, marked as done, and unmarked. It provides methods
 * to manipulate and retrieve tasks from the list.
 * </p>
 */
public class TaskList {
    private ArrayList<Task> tasks;


    /**
     * Constructs an empty {@code TaskList}.
     * <p>
     * Initializes the task list as an empty {@code ArrayList}.
     * </p>
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Constructs a {@code TaskList} with the specified list of tasks.
     *
     * @param tasks An {@code ArrayList} of {@link Task} objects to initialize the task list.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     *
     * @return An {@code ArrayList} containing all tasks in the list.
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Prints a summary message when a task is added to the list.
     * <p>
     * Displays a message confirming the addition of the task and the current number of tasks in the list.
     * </p>
     *
     * @param task The {@link Task} that has been added.
     */
    private void printAddedTaskSummary(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + this.tasks.size() + " tasks in the list.");
    }

    /**
     * Prints a summary message when a task is deleted from the list.
     * <p>
     * Displays a message confirming the removal of the task and the current number of tasks in the list.
     * </p>
     *
     * @param task The {@link Task} that has been removed.
     */
    private void printDeletedTaskSummary(Task task) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + this.tasks.size() + " tasks in the list.");
    }


    /**
     * Marks a task as done based on its index in the list.
     * <p>
     * Updates the status of the task at the specified index to completed.
     * </p>
     *
     * @param taskIndex The index of the task to be marked as done (1-based index).
     */
    public void markAsDone(int taskIndex) {
        this.tasks.get(taskIndex - 1).markAsDone();
    }

    /**
     * Unmarks a task as done based on its index in the list.
     * <p>
     * Updates the status of the task at the specified index to not completed.
     * </p>
     *
     * @param taskIndex The index of the task to be unmarked as done (1-based index).
     */
    public void unmarkAsDone(int taskIndex) {
        this.tasks.get(taskIndex - 1).unmarkAsDone();
    }

    /**
     * Adds a task to the list.
     * <p>
     * Adds the specified {@link Task} to the list and prints a summary of the added task.
     * </p>
     *
     * @param task The {@link Task} to be added.
     */
    public void addTask(Task task) {
        this.tasks.add(task);
        this.printAddedTaskSummary(task);
    }

    /**
     * Deletes a task from the list based on its index.
     * <p>
     * Removes the task at the specified index from the list and prints a summary of the deleted task.
     * </p>
     *
     * @param taskIndex The index of the task to be deleted (1-based index).
     */
    public void deleteTask(int taskIndex) {
        Task deletedTask = this.tasks.remove(taskIndex - 1);
        printDeletedTaskSummary(deletedTask);
    }

    /**
     * Returns a string representation of the task list for display purposes.
     * <p>
     * The string format is a numbered list of tasks, with each task on a new line.
     * </p>
     *
     * @return A string representation of the task list.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            output.append((i + 1)).append(".").append(this.tasks.get(i)).append(System.lineSeparator());
        }
        return output.toString();
    }
}
