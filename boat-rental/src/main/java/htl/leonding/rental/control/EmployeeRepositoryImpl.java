package htl.leonding.rental.control;

import htl.leonding.rental.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void remove(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("select e from br_employee e", Employee.class).getResultList();
    }
}
