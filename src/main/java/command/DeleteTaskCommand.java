package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to delete a task from the task list.
 */

public class DeleteTaskCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DeleteTaskCommand with the specified index of the task to be deleted.
     *
     * @param indexString The index of the task as a string.
     *                    It will be parsed into an integer.
     */
    public DeleteTaskCommand(String indexString) {
        this.taskIndex = Integer.parseInt((indexString));
    }

    /**
     * Executes the delete task command. Deletes the task from the task list
     * and handles any necessary UI and storage updates.
     *
     * @param taskList The list of tasks to delete the task from.
     * @param ui       The UI to display task deletion messages.
     * @param storage  The storage to save changes made to the task list.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.deleteTask(taskIndex);
    }
}
