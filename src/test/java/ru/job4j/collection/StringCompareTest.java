package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {

    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivan",
                "Ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanova",
                "Ivan"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightFirstCharDiffThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenLeftLessThanRightFirstCharDiffThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanova",
                "Petrova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrova"
        );
        assertThat(result).isLessThan(0);
    }
}


