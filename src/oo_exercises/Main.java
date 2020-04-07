package oo_exercises;

public class Main {
    public static void main(String[] args) {
        //1A
        Car car = new Car("Tesla", "red");
        car.drive();
        car.brake();
        System.out.println(car);
        //1B
        Car hisCar = new Car("Suzuki", "gray");
        hisCar.drive();
        hisCar.drive();
        hisCar.drive();
        System.out.println(hisCar);

        Truck truck1 = new Truck("Volvo", "blue");
        truck1.setCapacity(1000);

        RacingCar mySecondCar = new RacingCar("Ferarri", "red");

        Bicycle myCycle = new Bicycle("vanMook", "gray");
    }
}
