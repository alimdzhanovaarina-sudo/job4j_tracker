package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void when000to024then4pt47() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 2, 4);
        double expected = 4.47;
        double out = a.distance3d(b);
        assertThat(out).isCloseTo(expected, offset(0.01));
    }

    @Test
    void when111to456then7pt07() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(4, 5, 6);
        double expected = 7.07;
        double out = a.distance3d(b);
        assertThat(out).isCloseTo(expected, offset(0.01));
    }
}
