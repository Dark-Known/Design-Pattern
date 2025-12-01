package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class CargoInfoNotification {
    private String timeStamp;
    private String transportType;
    private int distanceInfo;
    private FurnitureInfo furnitureInfo;

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp=timeStamp;
    }
    public void setTransportType(String transportType)
    {
        this.transportType=transportType;
    }
    public void setCargoInfo(FurnitureInfo furnitureInfo)
    {
        this.furnitureInfo = furnitureInfo;
    }
    public void setDistanceInfo(int distanceInfo)
    {
        this.distanceInfo=distanceInfo;
    }
}
