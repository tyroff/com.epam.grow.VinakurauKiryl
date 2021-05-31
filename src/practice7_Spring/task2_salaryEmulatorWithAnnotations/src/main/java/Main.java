import entities.Employee;
import entities.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.EmployeeService;
import services.PositionService;
import services.SalaryService;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        ApplicationContext contextEntities = new AnnotationConfigApplicationContext("entities");
        ApplicationContext contextService = new AnnotationConfigApplicationContext("services");

        Position positionJunior = contextEntities.getBean(Position.class);
        positionJunior.setName("junior");
        Position positionMiddle = contextEntities.getBean(Position.class);
        positionMiddle.setName("middle");
        Position positionSenior = contextEntities.getBean(Position.class);
        positionSenior.setName("senior");
        Position positionDirector = contextEntities.getBean(Position.class);
        positionDirector.setName("director");

        PositionService positionService = contextService.getBean(PositionService.class);
        positionService.addPosition(positionJunior);
        positionService.addPosition(positionMiddle);
        positionService.addPosition(positionSenior);
        positionService.addPosition(positionDirector);

        Employee employee1 = contextEntities.getBean(Employee.class);
        employee1.setFirstName("Kiryl");
        employee1.setLastName("Vinakurau");
        employee1.setAge(37);
        employee1.setPosition(positionJunior);

        Employee employee2 = contextEntities.getBean(Employee.class);
        employee2.setFirstName("Uladzislau");
        employee2.setLastName("Shalamitski");
        employee2.setAge(29);
        employee2.setPosition(positionSenior);

        Employee employee3 = contextEntities.getBean(Employee.class);
        employee3.setFirstName("Andrei");
        employee3.setLastName("Khadziukou");
        employee3.setAge(33);
        employee3.setPosition(positionDirector);

        EmployeeService employeeService = contextService.getBean(EmployeeService.class);
        employeeService.hireEmployee(employee1);
        employeeService.hireEmployee(employee2);
        employeeService.hireEmployee(employee3);

        SalaryService salaryService = contextService.getBean(SalaryService.class);

        System.out.println(salaryService.valueSalary(employee1.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee2.getPosition().getName()));
        System.out.println(salaryService.valueSalary(employee3.getPosition().getName()));
    }
}
