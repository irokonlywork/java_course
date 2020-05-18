package ru.stqa.course.sandboх;

import org.testng.Assert;

import org.testng.annotations.Test;
import ru.stqa.course.sandbox.Square;

public class SquareTests {

    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(),25);
    }
}

