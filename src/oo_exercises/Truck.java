package oo_exercises;

public class Truck extends Car {
    private int capacity;

    public Truck(String brand, String color) {
        super(brand, color);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void drive() {
        speed += 5;
    }

    @Override
    public void brake() {
        speed -= 5;
    }
}
