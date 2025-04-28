package htl.leonding.rental.control;

import htl.leonding.rental.entity.Employee;
import java.util.List;

public interface EmployeeRepository {
    void add(Employee employee);
    void remove(Employee employee);
    Employee getEmployee(Long employeeId);
    List<Employee> getAllEmployees();
}
