package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(180, "BMW");
        Car car2 = new Car(240, "!Ferrari");
        Car car3 = new Car(90, "AJiguli");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.sort(Comparator.comparing(Car::getBrand));
        System.out.println(cars);
    }
}
