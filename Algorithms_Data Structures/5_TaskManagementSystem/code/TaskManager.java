public class TaskManager {
    private Task head;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Added: " + newTask);
    }

    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            System.out.println("Deleted: " + head);
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("Deleted: " + current.next);
            current.next = current.next.next;
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nTasks:");
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
