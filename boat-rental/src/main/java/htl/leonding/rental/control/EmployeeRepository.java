package htl.leonding.rental.control;

import htl.leonding.rental.entity.Employee;

public interface EmployeeRepository {
    void add(Employee employee);
    Employee getEmployee(Long employeeId);
}
