package com.musala.thedroneapi.exceptions;

public class WeightOverloadException extends Exception {
    public WeightOverloadException() {
        super("The weight exceeds the weight supported by the selected drone!");
    }
}
