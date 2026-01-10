package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);

        int resultSum = sum(10);
        int resultMinus = calculator.minus(10);
        int resultDivide = calculator.divide(10);
        int resultAll = calculator.sumAllOperation(10);

        System.out.println("Sum: " + resultSum);
        System.out.println("Minus: " + resultMinus);
        System.out.println("Divide: " + resultDivide);
        System.out.println("All: " + resultAll);
    }
}