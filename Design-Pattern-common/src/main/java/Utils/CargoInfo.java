package Utils;


public class CargoInfo {
    private final int distanceInfo;
    private final String cargoName;
    private final String transportType;
    private final FurnitureInfo furnitureInfoObj;

    public CargoInfo(String transportType, String cargoName, int distanceInfo, FurnitureInfo furnitureInfoObj) {


        validateCargoName(cargoName);
        validateTransportType(transportType);
        validateDistanceInfo(distanceInfo);
        this.cargoName = cargoName;
        this.transportType = transportType;
        this.distanceInfo = distanceInfo;
        this.furnitureInfoObj = furnitureInfoObj;
    }

    private void validateTransportType(String transportType)
    {
        if(transportType==null || transportType.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid Transport Type");
        }
    }
    private void validateCargoName(String cargoName)
    {
        if(cargoName==null || cargoName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid Cargo Name");
        }
    }

    private void validateDistanceInfo(int distanceInfo)
    {
        if(distanceInfo<10)
        {
            throw new IllegalArgumentException("Invalid Distance Information");
        }
    }

    public String getCargoName() {
        return this.cargoName;
    }

    public FurnitureInfo getFurnitureInfoObj() {
        return this.furnitureInfoObj;
    }

    public String getTransportType() {
        return this.transportType;
    }

    public int getDistanceInfo() {
        return this.distanceInfo;
    }


}






