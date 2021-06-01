package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.EmployeeService;
import services.PositionService;
import services.SalaryService;

/**
 * In this class, the service classes PositionService, EmployeeService and SalaryService are configured.
 *
 * @author Kiryl_Vinakurau
 */
@Configuration
public class ConfigurationService {

    /**
     * Creates a PositionService object
     *
     * @return new {@code PositionService}.
     */
    @Bean
    public PositionService getPositionService() {
        return new PositionService();
    }

    /**
     * Creates a EmployeeService object
     *
     * @return new {@code EmployeeService}.
     */
    @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeService();
    }

    /**
     * Creates a SalaryService object
     *
     * @return new {@code SalaryService}.
     */
    @Bean
    public SalaryService getSalaryService() {
        return new SalaryService();
    }

}
