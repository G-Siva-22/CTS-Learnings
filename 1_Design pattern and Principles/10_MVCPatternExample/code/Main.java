public class Main {
    public static void main(String[] args) {
        // Step 1: Create model and view
        Student student = new Student("John Doe", "S101", "A");
        StudentView view = new StudentView();

        // Step 2: Create controller
        StudentController controller = new StudentController(student, view);

        // Step 3: Display initial data
        controller.updateView();

        // Step 4: Update model data via controller
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        // Step 5: Display updated data
        controller.updateView();
    }
}
