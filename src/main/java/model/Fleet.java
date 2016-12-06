package model;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY, defaultImpl = Vehicle.class)
    @JsonSubTypes({
      @JsonSubTypes.Type(name = "car", value = Car.class),
      @JsonSubTypes.Type(name = "truck", value = Truck.class)
    })
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}