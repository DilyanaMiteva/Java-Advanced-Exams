package parking;

import parking.Car;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car ->
                car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().min((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are parked in ");
        output.append(getType()).append(":").append(System.lineSeparator());
        data.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }


}
