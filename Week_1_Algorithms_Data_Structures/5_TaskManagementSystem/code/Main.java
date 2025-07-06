public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(101, "Design UI", "Pending");
        manager.addTask(102, "Develop Backend", "In Progress");
        manager.addTask(103, "Write Docs", "Pending");

        manager.displayTasks();

        System.out.println("\nSearching for Task ID 102:");
        Task t = manager.searchTask(102);
        System.out.println(t != null ? t : "Not found");

        System.out.println("\nDeleting Task ID 102:");
        manager.deleteTask(102);

        manager.displayTasks();
    }
}
