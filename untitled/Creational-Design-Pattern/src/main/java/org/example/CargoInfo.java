package org.example;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class CargoInfo {
    private final int distanceInfo;
    private final String cargoName;
    private final String transportType;
    private final FurnitureInfo furnitureInfoObj;

    CargoInfo(String transportType, String cargoName,int distanceInfo, FurnitureInfo furnitureInfoObj)
    {

        this.cargoName=cargoName;
        this.transportType = transportType;
        this.distanceInfo=distanceInfo;
        this.furnitureInfoObj=furnitureInfoObj;
    }

    public String getCargoName(){
        return this.cargoName;
    }
    public FurnitureInfo getFurnitureInfoObj(){
        return this.furnitureInfoObj;
    }
    public String getTransportType()
    {
        return this.transportType;
    }
    public int getDistanceInfo()
    {
        return this.distanceInfo;
    }

}






