package com.startjava.lesson_2_3_4.calculator;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumber(String description) {
        super(description);
    }
}
