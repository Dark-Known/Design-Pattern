package org.example1;

public class JsonObj {
    private final String transportMode;
    private final int distance;
    private final String cargo;

    JsonObj(String transportMode, int distance, String cargo) {
        this.transportMode = transportMode;
        this.distance = distance;
        this.cargo = cargo;
    }

    public String getTransportMode() {
        return this.transportMode;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCargo() {
        return this.cargo;
    }

}

