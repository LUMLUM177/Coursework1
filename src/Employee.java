import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        id = COUNTER.getAndIncrement();
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return id + ": " + fullName + " работает в " + department + " отделе, зарплата составляет " + salary + " рублей.";
    }


}
