import entities.Employee;
import entities.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.EmployeeService;
import services.PositionService;
import services.SalaryService;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("configs");

        Position positionJunior = context.getBean("getJunior", Position.class);
        Position positionMiddle = context.getBean("getMiddle", Position.class);
        Position positionSenior = context.getBean("getSenior", Position.class);
        Position positionDirector = context.getBean("getDirector", Position.class);

        PositionService positionService = context.getBean(PositionService.class);
        positionService.addPosition(positionJunior);
        positionService.addPosition(positionMiddle);
        positionService.addPosition(positionSenior);
        positionService.addPosition(positionDirector);

        Employee employee1 =context.getBean("getEmployee1", Employee.class);
        Employee employee2 =context.getBean("getEmployee2", Employee.class);
        Employee employee3 =context.getBean("getEmployee3", Employee.class);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.hireEmployee(employee1);
        employeeService.hireEmployee(employee2);
        employeeService.hireEmployee(employee3);

        SalaryService salaryService = context.getBean(SalaryService.class);
        System.out.println(salaryService.valueSalary(employee1.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee2.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee3.getPosition().getName()));
    }
}
