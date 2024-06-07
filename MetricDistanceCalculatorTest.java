import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MetricDistanceCalculatorTest {
    @org.junit.jupiter.api.Test
    public void testSimpleAddition() throws Exception {
        double distance = MetricDistanceCalculator.calculateDistance("10 cm + 20 cm in mm");
        assertEquals(300, distance);
    }

    @org.junit.jupiter.api.Test
    public void testSubtraction() throws Exception {
        double distance = MetricDistanceCalculator.calculateDistance("1 m - 50 cm in dm");
        assertEquals(5, distance);
    }

    @org.junit.jupiter.api.Test
    public void testDifferentUnits() throws Exception {
        double distance = MetricDistanceCalculator.calculateDistance("2 km + 100 m in m");
        assertEquals(2100, distance);
    }

    @org.junit.jupiter.api.Test
    public void testInvalidExpression() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> MetricDistanceCalculator.calculateDistance("10cm"));
    }

    @org.junit.jupiter.api.Test
    public void testInvalidUnit() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> MetricDistanceCalculator.calculateDistance("10 inx + 20 cm in mm"));
    }
}