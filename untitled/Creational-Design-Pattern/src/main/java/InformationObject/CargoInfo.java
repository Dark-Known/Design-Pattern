package InformationObject;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class CargoInfo {
    private final int distanceInfo;
    private final String cargoName;
    private final String transportType;
    private final FurnitureInfo furnitureInfoObj;

    public CargoInfo(String transportType, String cargoName, int distanceInfo, FurnitureInfo furnitureInfoObj)
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
    public String getFamilyName(){
        // Get Family Name from cargo Name
        // Need to improve robust way to extract family and furniture name"
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[0];

    }
    public String getFurnitureName(){
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[1];
    }

}






