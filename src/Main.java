public class Main {

    private static void printAllEmployees(Employee[] array) {
        System.out.println("===========================       Данные о сотрудниках компании       ============================");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i]);
            } else {
                System.out.println("Данных не обнаружено.");
            }
        }
    }

    private static double calculateSumAllEmployes(Employee[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sum += array[i].getSalary();
            }
        }
        System.out.print("Общая сумма затрат на зарплаты всех сотрудников за месяц составит: ");
        return sum;
    }

    private static void findEmployeeMinSalary(Employee[] array) {
        double minSalary = array[0].getSalary();
        String employee = array[0].getFullName();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getSalary() < minSalary) {
                    minSalary = array[i].getSalary();
                    employee = array[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - это " + employee);
    }

    private static void findEmployeeMaxSalary(Employee[] array) {
        double maxSalary = array[0].getSalary();
        String employee = array[0].getFullName();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getSalary() > maxSalary) {
                    maxSalary = array[i].getSalary();
                    employee = array[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - это " + employee);
    }

    private static double calculateAvgSalary(Employee[] array) {
        int sum = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sum += array[i].getSalary();
                count++;
            }
        }
        System.out.print("Средняя зарплата сотрудников равна: ");
        return (double) sum / count;
    }

    private static void printFullNameEmployees(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.print("ФИО " + (i + 1) + "-го работника - ");
                System.out.println(array[i].getFullName());
            }
        }
    }

    private static void changeSalaryAllEmployees(Employee[] array, int percent) {
        double index = percent / 100.0;
        double newSalary;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newSalary = array[i].getSalary();
                newSalary += array[i].getSalary() * index;
                array[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплаты сотрудников увеличены на " + percent + " процентов.");
    }

    private static void findEmployeeMinSalaryByDepartment(Employee[] array, int department) {
        double minSalary = 1_000_000;
        String employee = "Данных по этому сотруднику не обнаружено.";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                if (array[i].getSalary() < minSalary) {
                    minSalary = array[i].getSalary();
                    employee = array[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой в " + department + "-м отделе - это " + employee);
    }

    private static void findEmployeeMaxSalaryByDepartment(Employee[] array, int department) {
        double maxSalary = 0;
        String employee = "Данных по этому сотруднику не обнаружено. ";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                if (array[i].getSalary() > maxSalary) {
                    maxSalary = array[i].getSalary();
                    employee = array[i].getFullName();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой в " + department + "-м отделе - это " + employee);
    }

    private static double calculateSumByDepartment(Employee[] array, int department) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                sum += array[i].getSalary();
            }
        }
        System.out.print("Общая сумма затрат на зарплаты сотрудников " + department + "-го отдела за месяц составит: ");
        return sum;
    }

    private static double calculateAvgSalaryByDepartment(Employee[] array, int department) {
        int sum = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                sum += array[i].getSalary();
                count++;
            }
        }
        System.out.print("Средняя зарплата сотрудников " + department + "-го отдела равна: ");
        return (double) sum / count;
    }

    private static void changeSalaryByDepartment(Employee[] array, int department, int percent) {
        double index = percent / 100.0;
        double newSalary;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                newSalary = array[i].getSalary();
                newSalary += array[i].getSalary() * index;
                array[i].setSalary(newSalary);
            }
        }
        System.out.println("Зарплаты сотрудников " + department + "-го отдела увеличены на " + percent + " процентов.");
    }

    private static void printEmpoyeesByDepartment(Employee[] array, int department) {
        System.out.println("Данные о сотрудниках " + department + "-го отдела:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getDepartment() == department) {
                System.out.print("ID сотрудника: " + array[i].getId());
                System.out.print(", ФИО сотрудника: " + array[i].getFullName());
                System.out.println(", зарплата сотрудника: " + array[i].getSalary());
            }
        }
    }

    private static void checkingSalaryIsLower(Employee[] array, double number) {
        System.out.println("Зарплата сотрудников ниже указанного числа: " + number);
        for (int i = 0; i < array.length; i++) {
            boolean salaryIsLower = array[i].getSalary() < number;
            if (salaryIsLower) {
                System.out.print("ID сотрудника: " + array[i].getId());
                System.out.print(", ФИО сотрудника: " + array[i].getFullName());
                System.out.println(", зарплата сотрудника: " + array[i].getSalary());
            }
        }
    }

    private static void checkingSalaryIsHigherOrEqual(Employee[] array, double number) {
        System.out.println("Зарплата сотрудников выше (либо равна) указанного числа: " + number);
        for (int i = 0; i < array.length; i++) {
            boolean salaryIsHigherOrEqual = array[i].getSalary() >= number;
            if (salaryIsHigherOrEqual) {
                System.out.print("ID сотрудника: " + array[i].getId());
                System.out.print(", ФИО сотрудника: " + array[i].getFullName());
                System.out.println(", зарплата сотрудника: " + array[i].getSalary());
            }
        }
    }


    public static void main(String[] args) {

        System.out.println();
        Employee kulakovNikolay = new Employee("Кулаков Николай Николаевич", 1, 50000);
        Employee kulakovVasiliy = new Employee("Кулаков Василий Николаевич", 1, 100000);
        Employee kulakovaEkaterina = new Employee("Кулакова Екатерина Николаевна", 2, 40000);
        Employee kulakovaNina = new Employee("Кулакова Нина Семёновна", 2, 30000);
        Employee podanevaAnastasiya = new Employee("Поданёва Анастасия Николаевна", 3, 35000);
        Employee kulakovaVeronika = new Employee("Кулакова Вероника Александровна", 3, 15000);
        Employee podanevTimofey = new Employee("Поданёв Тимофей Антонович", 4, 15000);
        Employee podanevMatvey = new Employee("Поданёв Матвей Антонович", 4, 10000);
        Employee podanevAnton = new Employee("Поданёв Антон Викторович", 5, 45000);
        Employee cibylkinaElizaveta = new Employee("Цыбулькина Елизавета Сергеевна", 5, 77000);

        Employee employees[] = new Employee[10];
        employees[0] = kulakovNikolay;
        employees[1] = kulakovVasiliy;
        employees[2] = kulakovaEkaterina;
        employees[3] = kulakovaNina;
        employees[4] = podanevaAnastasiya;
        employees[5] = kulakovaVeronika;
        employees[6] = podanevTimofey;
        employees[7] = podanevMatvey;
        employees[8] = podanevAnton;
        employees[9] = cibylkinaElizaveta;

        printAllEmployees(employees);
        System.out.println();
        System.out.println(calculateSumAllEmployes(employees) + " рублей.");
        findEmployeeMinSalary(employees);
        findEmployeeMaxSalary(employees);
        System.out.println(calculateAvgSalary(employees) + " рублей.");
        System.out.println();
        printFullNameEmployees(employees);

        System.out.println();
        changeSalaryAllEmployees(employees, 10);
        System.out.println();
        printAllEmployees(employees);

        System.out.println();
        System.out.println("============================================================================================");
        findEmployeeMinSalaryByDepartment(employees, 2);
        findEmployeeMaxSalaryByDepartment(employees, 1);
        System.out.println(calculateSumByDepartment(employees, 3) + " рублей.");
        System.out.println(calculateAvgSalaryByDepartment(employees, 4) + " рублей.");
        changeSalaryByDepartment(employees, 5, 100);
        System.out.println();
        printEmpoyeesByDepartment(employees, 5);
        System.out.println();
        checkingSalaryIsLower(employees, 11001);
        System.out.println();
        checkingSalaryIsHigherOrEqual(employees, 55000);
        System.out.println();
        kulakovNikolay.setDepartment(5);
        printEmpoyeesByDepartment(employees, 5);

        System.out.println();
        System.out.println("============================================================================================");
        System.out.println();
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.printAllEmployees();
        employeeBook.addEmployee("Арбузова Анна Александровна", 1, 30000);
        employeeBook.addEmployee("Винивитин Александр Викторович", 1, 70000);
        employeeBook.addEmployee("Лихоеденко Юрий Александрович", 2, 130000);
        employeeBook.addEmployee("Тищенко Павел Петрович", 2, 20000);
        employeeBook.addEmployee("Шевченко Надежда Николаевна", 3, 40000);
        employeeBook.addEmployee("Исаева Ирина Григорьевна", 3, 50000);
        employeeBook.addEmployee("Смирнова Екатерина Викторовна", 4, 60000);
        employeeBook.addEmployee("Щукин Олег Александрович", 4, 70000);
        employeeBook.addEmployee("Алавердян Сергей Мартикович", 5, 80000);
        employeeBook.addEmployee("Кочарян Артур Сагибетович", 5, 90000);
        employeeBook.printAllEmployees();

        System.out.println();
        employeeBook.removeEmployee("Тищенко Павел Петрович");
        System.out.println();
        employeeBook.printAllEmployees();
        employeeBook.addEmployee("Кулаков Егор Васильевич", 2, 35000);
        System.out.println();
        employeeBook.printAllEmployees();
        System.out.println();
        employeeBook.addEmployee("Кулаков Егор Васильевич", 2, 35000);
        System.out.println();

        System.out.println(employeeBook.calculateSumAllEmployes() + " рублей.");
        System.out.println();
        employeeBook.changeEmployeeSalaryAndDepartment("Алавердян Сергей Мартикович", 77000, 3);
        System.out.println();
        employeeBook.printAllEmployees();
        System.out.println();
        employeeBook.printEmployeesByDepartment();


    }
}