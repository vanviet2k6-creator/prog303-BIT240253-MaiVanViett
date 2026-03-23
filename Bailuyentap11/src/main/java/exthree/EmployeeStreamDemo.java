package exthree;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "An", 900),
                new Employee(2, "Binh", 1500),
                new Employee(3, "Cuong", 1200),
                new Employee(4, "Dung", 800)
        );

        List<String> result = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Danh sach ten nhan vien luonng > 1000:");
        result.forEach(System.out::println);
    }
}