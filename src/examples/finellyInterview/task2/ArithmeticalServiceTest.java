package examples.finellyInterview.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        assertTrue(arithmeticalService.performOperation("summa", 1, 2) == 3);
    }

    @Test
    public void testPerformOperationSummaNegative() {
        assertFalse(arithmeticalService.performOperation("summa", 1, 2) == 4);
    }

    @Test
    public void testPerformOperationMultiplyPositive() {
        assertTrue(arithmeticalService.performOperation("multiply", 1, 2) == 2);
    }

    @Test
    public void testPerformOperationMultiplyNegative() {
        assertFalse(arithmeticalService.performOperation("multiply", 1, 2) == 3);
    }

    @Test
    public void testPerformOperationDivisionsPositive() {
        assertTrue(arithmeticalService.performOperation("divisions", 4, 2) == 2);
    }

    @Test
    public void testPerformOperationDivisionsNegative() {
        assertFalse(arithmeticalService.performOperation("divisions", 4, 2) == 5);
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void testPerformOperationDivisionsByZero() {
        arithmeticalService.performOperation("divisions", 4, 0);
    }

    @Test
    public void testPerformOperationSubtractionPositive() {
        assertTrue(arithmeticalService.performOperation("subtraction", 4, 2) == 2);
    }

    @Test
    public void testPerformOperationSubtractionNegative() {
        assertFalse(arithmeticalService.performOperation("subtraction", 4, 2) == 5);
    }

    @Test
    public void testPerformOperationSubtractionNotOperation() {
        assertEquals(null, arithmeticalService.performOperation("null", 4, 2));
    }
}
