package com.company;

import java.util.Comparator;

public class CarComporator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getSpeed() - o2.getSpeed();
    }
}
