package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2.0;
        double out = a.distance(b);
        assertThat(out).isCloseTo(expected, offset(0.01));
    }

    @Test
    void when00to02then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2.0;
        double out = a.distance(b);
        assertThat(out).isCloseTo(expected, offset(0.01));
    }
}