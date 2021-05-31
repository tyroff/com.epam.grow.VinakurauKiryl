package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Bind salary to position
 *
 * @author Kiryl_Vinakurau
 */
@Service
@Scope("singleton")
public class SalaryService {

    private static final int BASE_SALARY = 2500;
    private Map<String, Double> coefficientPosition;

    @Autowired
    public SalaryService() {
        coefficientPosition = new HashMap<>();
        coefficientPosition.put("junior", 0.2);
        coefficientPosition.put("middle", 0.4);
        coefficientPosition.put("senior", 0.8);
        coefficientPosition.put("director", 2.2);
    }

    /**
     * Calculate the value of salary.
     *
     * @param position name of position.
     * @return value of position.
     */
    public Double valueSalary(String position) {
        if (position == null) throw new NullPointerException();
        if (!coefficientPosition.containsKey(position)) throw new IllegalArgumentException("The map isn't contains key.");
        return BASE_SALARY * coefficientPosition.get(position);
    }
}
