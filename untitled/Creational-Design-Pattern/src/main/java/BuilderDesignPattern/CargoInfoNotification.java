package BuilderDesignPattern;

import AbstractFactoryDesignPattern.CargoInfo;

public class CargoInfoNotification {
    private String timeStamp;
    private String transportType;
    private int distanceInfo;
    private CargoInfo cargoInfo;

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp=timeStamp;
    }
    public void setTransportType(String transportType)
    {
        this.transportType=transportType;
    }
    public void setCargoInfo(CargoInfo cargoInfo)
    {
        this.cargoInfo=cargoInfo;
    }
    public void setDistanceInfo(int distanceInfo)
    {
        this.distanceInfo=distanceInfo;
    }
}
