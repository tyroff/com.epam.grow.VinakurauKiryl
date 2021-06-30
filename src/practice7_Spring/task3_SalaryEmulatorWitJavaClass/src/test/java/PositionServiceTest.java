import entities.Employee;
import entities.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.EmployeeService;
import services.PositionService;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PositionServiceTest {

    private PositionService positionService;
    private Position position = new Position("Position");
    private Long maxId = Long.MAX_VALUE;

    @Before
    public void setUp() {
        positionService = new PositionService();
    }

    @After
    public void tearDown() {
        positionService = null;
        position = null;
        maxId = null;
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
    public void testAddPositionElseNull() {
        positionService.addPosition(null);
    }

    @Test
    public void testAddPositionElseTrue() {
        positionService.addPosition(position);
        Position addPosition = positionService.findAll().get(1L);
        assertTrue(position.equals(addPosition));
    }

    @Test(expected = NullPointerException.class)
    public void testDeletePositionElseNull() {
        positionService.deletePosition(null);
    }

    @Test
    public void testDeletePositionIsDelete() {
        Map<Long, Position> map = positionService.findAll();
        positionService.addPosition(position);
        positionService.addPosition(position);
        positionService.deletePosition(position);
        assertFalse(map.containsValue(position));
    }

    @Test(expected = NullPointerException.class)
    public void testUpdatePositionByPositionOnNull() {
        positionService.updatePosition(1L,null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdatePositionByIdOnNull() {
        positionService.updatePosition(null, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePositionIfIdOnZero() {
        positionService.updatePosition(0L, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePositionDoNotContainId() {
        positionService.addPosition(position);
        positionService.updatePosition(2L, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePositionIfIdMoreMax() {
        positionService.updatePosition(++maxId, position);
    }
}
