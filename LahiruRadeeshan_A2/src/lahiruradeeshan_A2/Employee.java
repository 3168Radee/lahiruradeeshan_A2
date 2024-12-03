package lahiruradeeshan_A2;

public class Employee extends Person {
    private String employeeId;
    private String role;

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(String name, int age, String contactNumber, String employeeId, String role) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.role = role;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
