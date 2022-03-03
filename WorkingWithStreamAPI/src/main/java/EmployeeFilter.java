import java.time.LocalDate;
import java.util.List;

public interface EmployeeFilter {

    void print3MaxSalaries(List<Employee> employeeList);
    void findWomanWithBirthdayAfter(List<Employee> employeeList, LocalDate date);
    void printInformationAbout(List<Employee> employeeList);
    void printSalariesAsc(List<Employee> employeeList);
    void printUniqueSalaries(List<Employee> employeeList);

}
