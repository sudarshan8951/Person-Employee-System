import java.util.*;

class Student {
    private String name;
    private String program;
    private int semester;
    private Map<String, Integer> courses; // Course Name -> Marks

    public Student(String name, String program, int semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courses = new HashMap<>();
    }

    public void registerCourse(String courseName, int marks) {
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks for " + courseName + ". Must be between 0 and 100.");
            return;
        }
        courses.put(courseName, marks);
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Registered Courses: " + courses.keySet());
    }

    public void displayLowMarks() {
        System.out.println("Courses with Marks Below 40:");
        boolean found = false;
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() < 40) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    public void displayAverageMarks() {
        if (courses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        int total = 0;
        for (int marks : courses.values()) {
            total += marks;
        }
        double average = total / (double) courses.size();
        System.out.println("Average Marks: " + average);
    }

    public void displayPassStatus() {
        boolean allPassed = true;
        for (int marks : courses.values()) {
            if (marks < 40) {
                allPassed = false;
                break;
            }
        }
        System.out.println(allPassed ? "Status: Passed All Courses" : "Status: Failed in Some Courses");
    }

    public static void main(String[] args) {
        Student student = new Student("John Doe", "Computer Science", 3);
        student.registerCourse("Mathematics", 75);
        student.registerCourse("Physics", 35);
        student.registerCourse("Chemistry", 90);
        student.registerCourse("History", 28);
        student.registerCourse("Art", 105); // Invalid input test

        student.displayStudentDetails();
        student.displayLowMarks();
        student.displayAverageMarks();
        student.displayPassStatus();
    }
}
