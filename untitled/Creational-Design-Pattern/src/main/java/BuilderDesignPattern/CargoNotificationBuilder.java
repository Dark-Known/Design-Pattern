package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;
import AbstractFactoryDesignPattern.FurnitureSelector;

public class CargoNotificationBuilder implements Builder<CargoInfoNotification>{
    private String transportType;
    private int distanceInfo;
    private FurnitureInfo furnitureInfo;
    private String cargoName;
    private String userName;
    private String userAddress;
    private String timeStamp;

//    @Override
//    public Builder<CargoInfoNotification> reset() {
//        new CargoInfoNotification();
//        return this;
//    }

    @Override
    public Builder<CargoInfoNotification> setTransportType(String transportType) {
        this.transportType=transportType;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setDistanceInfo(int distanceInfo) {
        this.distanceInfo=distanceInfo;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setCargoInfo(FurnitureInfo furnitureInfo,String cargoName) {
        this.furnitureInfo=furnitureInfo;
        this.cargoName=cargoName;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserName(String userName) {
        this.userName=userName;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserAddress(String userAddress) {
        this.userAddress=userAddress;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setSourceAddress(String sourceAddress) {
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setDestAddress(String destAddress) {
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setTimeStamp(String timeStamp) {
        this.timeStamp=timeStamp;
        return this;
    }

    private void validateTransportType()
    {

    }
    private void validateDistanceInfo()
    {

    }
    private void validate

    private void validateUserName()
    {

    }
    private void validateUserAddress()
    {

    }


    public CargoInfoNotification build(){
        return notification;
    }
}
