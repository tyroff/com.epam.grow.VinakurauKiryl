package services;

import entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Hire/fire new Employees for the specific position
 *
 * @author Kiryl_Vinakurau
 */
@Service
@Scope("singleton")
public class EmployeeService {

    private Map<Long, Employee> employeeMap;
    private Long id = 0L;
    private Long maxId = Long.MAX_VALUE;

    @Autowired
    public EmployeeService() {
        employeeMap = new HashMap<>();
    }

    /**
     * Adds a new employee to the {@code employeeMap}
     *
     * @param employee a new employee.
     */
    public void hireEmployee(Employee employee) {
        if (employee == null) throw new NullPointerException();
        employeeMap.put(++id, employee);
    }

    /**
     * Removes an employee from the {@code employeeMap}.
     *
     * @param id employee number.
     */
    public void fireEmployeeById(Long id) {
        if (id == null) throw new NullPointerException();
        if (id > maxId || id <= 0) throw new IllegalArgumentException("The id value is incorrect.");
        employeeMap.remove(id);
    }

    /**
     * Outputs all values of the {@code employeeMap}
     */
    public Map<Long, Employee> findAll() {
        if (employeeMap.isEmpty()) throw new NullPointerException();
        return employeeMap;
    }
}
