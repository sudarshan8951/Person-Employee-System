import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Person {
    private String name;
    private String dob;
    
    public Person(String name, String dob) throws ParseException {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dob); 
        this.dob = sdf.format(date); 
    }

    public void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
    }
}

class Employee extends Person {
    private int empId;
    private double salary;
    
    public Employee(String name, String dob, int empId, double salary) throws ParseException {
        super(name, dob); 
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayPersonDetails(); 
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }

    public static void main(String[] args) throws ParseException {
        Employee emp = new Employee("Alice", "15-08-1990", 101, 75000);
        emp.displayEmployeeDetails();
    }
}
