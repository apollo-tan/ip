package task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a description and completion status.
 * <p>
 * The {@code Task} class provides common functionality for tasks, including managing
 * their descriptions and completion status. It provides methods to mark tasks as
 * done or not done, and to obtain their string representations for display and storage.
 * </p>
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a {@code Task} with the specified description and sets the task as not done.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructs a {@code Task} with the specified description and completion status.
     *
     * @param description The description of the task.
     * @param isDone      A boolean indicating whether the task is completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Returns a string representation of the task suitable for database storage.
     * <p>
     * This method must be implemented by subclasses to provide a format that can be
     * saved and later reconstructed from the database.
     * </p>
     *
     * @return A string representation of the task for database storage.
     */
    public abstract String getDatabaseString();

    /**
     * Returns the status icon for the task.
     * <p>
     * The icon is "X" if the task is completed and a space (" ") if it is not completed.
     * </p>
     *
     * @return The status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done and prints a confirmation message.
     * <p>
     * This method updates the completion status of the task to true and displays
     * a message indicating that the task has been marked as done.
     * </p>
     */
    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(this);
    }

    /**
     * Marks the task as not done and prints a confirmation message.
     * <p>
     * This method updates the completion status of the task to false and displays
     * a message indicating that the task has been marked as not done yet.
     * </p>
     */
    public void unmarkAsDone() {
        this.isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(this);
    }

    /**
     * Returns a string representation of the task for display purposes.
     * <p>
     * The string format is "[status icon] description". The status icon indicates
     * whether the task is completed.
     * </p>
     *
     * @return A string representation of the task for display.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + " " + this.description;
    }

    /**
     * Formats a {@code LocalDate} object for display in a user-friendly format.
     * <p>
     * The format used is "MMM d yyyy" (e.g., "Sep 6 2024").
     * </p>
     *
     * @param date The {@code LocalDate} to be formatted.
     * @return The formatted date string for display.
     */
    public static String getDateStringPrintFormat(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    /**
     * Formats a {@code LocalDate} object for storage in a consistent format.
     * <p>
     * The format used is "yyyy-MM-dd" (e.g., "2024-09-06").
     * </p>
     *
     * @param date The {@code LocalDate} to be formatted.
     * @return The formatted date string for storage.
     */
    public static String getDateStringStorageFormat(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}