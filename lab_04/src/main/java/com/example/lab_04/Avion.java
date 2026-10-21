package com.example.lab_04;
public class Avion{

    String Model;
    String Id;
    String Manufacturer;
    Integer FlightHours;
    Float Value;
    public Avion() {
    }

    public Avion(String model, String id, String manufacturer, Integer flightHours, Float value) {
        Model = model;
        Id = id;
        Manufacturer = manufacturer;
        FlightHours = flightHours;
        Value = value;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public Integer getFlightHours() {
        return FlightHours;
    }

    public void setFlightHours(Integer flightHours) {
        FlightHours = flightHours;
    }

    public Float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        Value = value;
    }
}
