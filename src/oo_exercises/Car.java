package oo_exercises;

public class Car implements Vehicle {
    private String brand;
    private String color;
    protected int speed;

    public Car(String brand, String color) {
        //3 constructor
        this.brand = brand;
        this.color = color;
    }

    //5 make tostring for speed +get/set
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

    //2 getters/setters
    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void drive() {
        speed += 10;
    }

    @Override
    public void brake() {
        speed -= 10;
    }
}
