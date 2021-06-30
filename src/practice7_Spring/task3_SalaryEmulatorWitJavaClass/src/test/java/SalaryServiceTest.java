import entities.Position;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import services.PositionService;
import services.SalaryService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SalaryServiceTest {

    private SalaryService salaryService;
    private Position position = new Position("Position");

    @Before
    public void setUp() {
        salaryService = new SalaryService();
    }

    @After
    public void tearDown() {
        salaryService = null;
        position = null;
    }

    @Test
    public void testPositionIsThisPositionHashCodeTrue() {
        int old = position.hashCode();
        assertThat(position.hashCode(), is(old));
    }

    @Test
    public void testPositionIsThisPositionEqualsTrue() {
        Position copyPosition = position;
        assertTrue(position.equals(copyPosition));
    }

    @Test
    public void testPositionIsThisPositionHashCodeFalse() {
        int old = new Object().hashCode();
        assertFalse(position.hashCode() == old);
    }

    @Test
    public void testPositionIsThisPositionEqualsFalse() {
        assertFalse(position.equals(new Object()));
    }

    @Test(expected = NullPointerException.class)
    public void testValueSalaryElseNull() {
        salaryService.valueSalary(null);
    }
}
