package ru.job4j.function;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FunctionCalculatorTest {

    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator calc = new FunctionCalculator();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11.0, 13.0, 15.0);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator calc = new FunctionCalculator();
        List<Double> result = calc.diapason(2, 5, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4.0, 9.0, 16.0);
        assertThat(result).containsExactlyElementsOf(expected);
    }

    @Test
    void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator calc = new FunctionCalculator();
        List<Double> result = calc.diapason(0, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1.0, 2.0, 4.0);
        assertThat(result).containsExactlyElementsOf(expected);
    }
}

