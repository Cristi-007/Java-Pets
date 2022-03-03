import enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee("Elena", 56542, Gender.FEMALE, LocalDate.of(2000,02,25)));
        employeeList.add(new Employee("Ion", 35452, Gender.MALE, LocalDate.of(1954,03,03)));
        employeeList.add(new Employee("Maria", 564545, Gender.FEMALE, LocalDate.of(1988,05,20)));

        ClassicEmployeeFilter filter = new ClassicEmployeeFilter();



    }
}
