import entities.Employee;
import entities.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.EmployeeService;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private Position position = new Position("position");
    private Employee employee = new Employee("firstName", "lastName", 18, position);
    private Long maxId = Long.MAX_VALUE;

    @Before
    public void setUp() {
        employeeService = new EmployeeService();
    }

    @After
    public void tearDown() {
        employeeService = null;
        position = null;
        employee = null;
        maxId = null;
    }


    @Test
    public void testEmployeeIsThisEmployeeHashCodeTrue() {
        int old = employee.hashCode();
        assertThat(employee.hashCode(), is(old));
    }

    @Test
    public void testEmployeeIsThisEmployeeEqualsTrue() {
        Employee copyEmployee = employee;
        assertTrue(employee.equals(copyEmployee));
    }

    @Test
    public void testEmployeeIsThisEmployeeHashCodeFalse() {
        int old = new Object().hashCode();
        assertFalse(employee.hashCode() == old);
    }

    @Test
    public void testEmployeeIsThisEmployeeEqualsFalse() {
        assertFalse(employee.equals(new Object()));
    }

    @Test(expected = NullPointerException.class)
    public void testHireEmployeeOnNull() {
        employeeService.hireEmployee(null);
    }

    @Test(expected = NullPointerException.class)
    public void testFireEmployeeByIdOnNull() {
        employeeService.fireEmployeeById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFireEmployeeIfIdOnZero() {
        employeeService.fireEmployeeById(0L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFireEmployeeIfIdMoreMax() {
        employeeService.fireEmployeeById(++maxId);
    }

    @Test(expected = NullPointerException.class)
    public void testFindAll() {
        Map<Long, Employee> map = employeeService.findAll();
        assertNull(map.isEmpty());
    }
}