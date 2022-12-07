package com.musala.thedroneapi.exceptions;


public class BatteryCapacityException extends Exception{
    public BatteryCapacityException() {
        super("Battery level is below the required level!");
    }
}
