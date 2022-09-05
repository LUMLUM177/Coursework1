public class EmployeeBook {

    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Книга сотрудников переполнена. Добавление нового сотрудника невозможно.");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                size++;
                break;
            }
        }

    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                if (i == employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - i);
                }
                size--;
                System.out.println("Сотрудник " + fullName + " удалён.");
                return;
            }
        }
        System.out.println("Сотрудник " + fullName + " не найден.");
    }

    public void changeEmployeeSalaryAndDepartment(String fullName, double salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                employees[i].setSalary(salary);
                employees[i].setDepartment(department);
                System.out.println("У сотрудника " + fullName + " обновились данные по зарплате и отделу.");
                return;
            }
        }
        System.out.println("Сотрудник " + fullName + " не найден.");
    }

    public void printAllEmployees() {
        System.out.println("===========================       Данные о сотрудниках компании       ============================");
        System.out.println();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            } else {
                System.out.println("Данных не обнаружено.");
            }
        }
    }

    public double calculateSumAllEmployes() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }
        System.out.print("Общая сумма затрат на зарплаты всех сотрудников за месяц составит: ");
        return sum;
    }

    public void findEmployeeMinSalary() {
        double minSalary = employees[0].getSalary();
        String employee = employees[0].getFullName();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    employee = employees[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - это " + employee);
    }

    public void findEmployeeMaxSalary() {
        double maxSalary = employees[0].getSalary();
        String employee = employees[0].getFullName();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    employee = employees[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - это " + employee);
    }

    public double calculateAvgSalary() {
        int sum = 0, count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
                count++;
            }
        }
        System.out.print("Средняя зарплата сотрудников равна: ");
        return (double) sum / count;
    }

    public void printFullNameEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.print("ФИО " + (i + 1) + "-го работника - ");
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public void changeSalaryAllEmployees(int percent) {
        double index = percent / 100.0;
        double newSalary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSalary = employees[i].getSalary();
                newSalary += employees[i].getSalary() * index;
                employees[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплаты сотрудников увеличены на " + percent + " процентов.");
    }

    public void findEmployeeMinSalaryByDepartment(int department) {
        double minSalary = 1_000_000;
        String employee = "Данных по этому сотруднику не обнаружено.";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    employee = employees[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой в " + department + "-м отделе - это " + employee);
    }

    public void findEmployeeMaxSalaryByDepartment(int department) {
        double maxSalary = 0;
        String employee = "Данных по этому сотруднику не обнаружено. ";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    employee = employees[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой в " + department + "-м отделе - это " + employee);
    }

    public double calculateSumByDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        System.out.print("Общая сумма затрат на зарплаты сотрудников " + department + "-го отдела за месяц составит: ");
        return sum;
    }

    public double calculateAvgSalaryByDepartment(int department) {
        int sum = 0, count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
                count++;
            }
        }
        System.out.print("Средняя зарплата сотрудников " + department + "-го отдела равна: ");
        return (double) sum / count;
    }

    public void changeSalaryByDepartment(int department, int percent) {
        double index = percent / 100.0;
        double newSalary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                newSalary = employees[i].getSalary();
                newSalary += employees[i].getSalary() * index;
                employees[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплаты сотрудников " + department + "-го отдела увеличены на " + percent + " процентов.");
    }

    public void printEmpoyeesByDepartment(int department) {
        System.out.println("Данные о сотрудниках " + department + "-го отдела:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.print("ID сотрудника: " + employees[i].getId());
                System.out.print(", ФИО сотрудника: " + employees[i].getFullName());
                System.out.println(", зарплата сотрудника: " + employees[i].getSalary());
            }
        }
    }

    public void checkingSalaryIsLower(double number) {
        System.out.println("Зарплата сотрудников ниже указанного числа: " + number);
        for (int i = 0; i < employees.length; i++) {
            boolean salaryIsLower = employees[i].getSalary() < number;
            if (salaryIsLower) {
                System.out.print("ID сотрудника: " + employees[i].getId());
                System.out.print(", ФИО сотрудника: " + employees[i].getFullName());
                System.out.println(", зарплата сотрудника: " + employees[i].getSalary());
            }
        }
    }

    public void checkingSalaryIsHigherOrEqual(double number) {
        System.out.println("Зарплата сотрудников выше (либо равна) указанного числа: " + number);
        for (int i = 0; i < employees.length; i++) {
            boolean salaryIsHigherOrEqual = employees[i].getSalary() >= number;
            if (salaryIsHigherOrEqual) {
                System.out.print("ID сотрудника: " + employees[i].getId());
                System.out.print(", ФИО сотрудника: " + employees[i].getFullName());
                System.out.println(", зарплата сотрудника: " + employees[i].getSalary());
            }
        }
    }

    public void printEmployeesByDepartment() {
        System.out.println("===========================       Данные о сотрудниках по отделам       ============================");
        System.out.println();
        int countDepartments = 5;
        for (int department = 1; department <= countDepartments; department++) {
            System.out.println("Список сотрудников " + department + "-го отдеала: ");
            for (int j = 0; j < employees.length; j++) {
                if (employees[j].getDepartment() == department) {
                    System.out.println(employees[j].getFullName());
                }
            }
        }
    }
}
