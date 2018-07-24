package models;

public class Car {
    private String licensePlate;
    private String engine;
    private String gearbox;

    public Car(String licensePlate, String engine, String gearbox) {
        this.licensePlate = licensePlate;
        this.engine = engine;
        this.gearbox = gearbox;
    }

    public Car() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }
}

