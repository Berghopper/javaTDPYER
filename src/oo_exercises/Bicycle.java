package oo_exercises;

public class Bicycle implements Vehicle {
    private String brand;
    private String color;
    protected int speed;

    public Bicycle(String brand, String color) {
        //3 constructor
        this.brand = brand;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void drive() {
        speed += 2;
    }

    @Override
    public void brake() {
        speed += 2;
    }
}
