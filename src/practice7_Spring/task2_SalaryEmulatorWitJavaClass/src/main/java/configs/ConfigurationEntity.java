package configs;

import entities.Employee;
import entities.Position;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * In this class, the entity classes Position and Employee are configured.
 *
 * @author Kiryl_Vinakurau
 */
@Configuration
public class ConfigurationEntity {

    /**
     * Creates a Junior Position object
     *
     * @return {@code Position} junior.
     */
    @Bean
    public Position getJunior() {
        return new Position("junior");
    }

    /**
     * Creates a Middle Position object
     *
     * @return {@code Position} middle.
     */
    @Bean
    public Position getMiddle() {
        return new Position("middle");
    }

    /**
     * Creates a Senior Position object
     *
     * @return {@code Position} senior.
     */
    @Bean
    public Position getSenior() {
        return new Position("senior");
    }

    /**
     * Creates a Director Position object
     *
     * @return {@code Position} director.
     */
    @Bean
    public Position getDirector() {
        return new Position("director");
    }

    /**
     * Creates a employee Employee object
     *
     * @return new {@code Employee}.
     */
    @Bean
    public Employee getEmployee1() {
        return new Employee("Kiryl", "Vinakurau", 37, getJunior());
    }

    /**
     * Creates a employee Employee object
     *
     * @return new {@code Employee}.
     */
    @Bean
    public Employee getEmployee2() {
        return new Employee("Uladzislau", "Shalamitski", 29, getSenior());
    }

    /**
     * Creates a employee Employee object
     *
     * @return new {@code Employee}.
     */
    @Bean
    public Employee getEmployee3() {
        return new Employee("Andrei", "Khadziukou", 33, getDirector());
    }

}
