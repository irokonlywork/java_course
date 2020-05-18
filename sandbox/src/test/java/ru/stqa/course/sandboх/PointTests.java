package ru.stqa.course.sandboх;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.course.sandbox.Point;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(2,3);
        Point p2 = new Point(4,6);
        Assert.assertEquals(p1.distance(1,2), 1.4142135623730951);
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(2,3);
        Point p2 = new Point(4,6);
        Assert.assertEquals(p1.distance(p2), 3.605551275463989);
    }

    @Test
    public void testDistance3() {
        Point p1 = new Point(2,3);
        Point p2 = new Point(4,6);
        Assert.assertEquals(p1.distance(p2), 3, "Неверный фактический результат");
    }
}
