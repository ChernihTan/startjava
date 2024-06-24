package com.startjava.lesson_2_3_4.calculator;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String description) {
        super(description);
    }
}
