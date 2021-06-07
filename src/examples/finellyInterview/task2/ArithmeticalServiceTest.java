package examples.finellyInterview.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArithmeticalServiceTest {
    private ArithmeticalService arithmeticalService;

    @Before
    public void setUp() {
        arithmeticalService = new ArithmeticalService();
    }

    @After
    public void tearDown() {
        arithmeticalService = null;
    }

    @Test
    public void testPerformOperationSummaPositive() {

    }

/*    @Test
    public void testPerformOperationSummaPositive() {
        assertEquals(arithmeticalService.performOperation("summa", 1, 2), 3L);
    }

    @Test
    public void testPerformOperationMultiplyPositive() {
        Integer sum = arithmeticalService.performOperation("multiply", 1, 2);
    }

    @Test
    public void testPerformOperationDivisionsPositive() {
        Integer sum = arithmeticalService.performOperation("divisions", 4, 2);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testPerformOperationDivisionsByZero() {
        Integer sum = arithmeticalService.performOperation("divisions", 4, 0);
    }

    @Test
    public void testPerformOperationSubtractionPositive() {
        Integer sum = arithmeticalService.performOperation("subtraction", 4, 2);
    }

    @Test
    public void testPerformOperationSubtractionNotOperation() {
        assertEquals(null, arithmeticalService.performOperation("null", 4, 2));
    }*/
}
