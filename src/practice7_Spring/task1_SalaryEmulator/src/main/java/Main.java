import entities.Employee;
import entities.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.EmployeeService;
import services.PositionService;
import services.SalaryService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        PositionService positionService = (PositionService) context.getBean("positionServer");
        positionService.addPosition((Position) context.getBean("junior"));
        positionService.addPosition((Position) context.getBean("middle"));
        positionService.addPosition((Position) context.getBean("senior"));
        positionService.addPosition((Position) context.getBean("director"));

        SalaryService salaryService = (SalaryService) context.getBean("salaryService");

        Employee employee1 = (Employee) context.getBean("employee1");
        Employee employee2 = (Employee) context.getBean("employee2");
        Employee employee3 = (Employee) context.getBean("employee3");

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        employeeService.hireEmployee(employee1);
        employeeService.hireEmployee(employee2);
        employeeService.hireEmployee(employee3);

        System.out.println(salaryService.valueSalary(employee1.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee2.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee3.getPosition().getName()));
    }
}
