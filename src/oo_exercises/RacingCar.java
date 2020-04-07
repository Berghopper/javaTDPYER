package oo_exercises;

public class RacingCar extends Car {
    private int maxSpeed;

    public RacingCar(String brand, String color) {
        super(brand, color);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
