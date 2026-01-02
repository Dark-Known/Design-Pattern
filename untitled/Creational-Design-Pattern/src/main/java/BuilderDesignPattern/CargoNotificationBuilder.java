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
        if(transportType.isEmpty())
        {
            throw new IllegalStateException("Transport Type cannot be null");
        }

    }
    private void validateDistanceInfo()
    {
        if(distanceInfo<10)
        {
            throw new IllegalStateException("Invalid distance Info");
        }

    }
    private void validateCargoName()
    {
        if(cargoName.isEmpty())
        {
            throw new IllegalStateException("Invalid Cargo Name");
        }
    }

    private void validateUserName()
    {
        if(userName.isEmpty())
        {
            throw new IllegalStateException("Invalid User Name");
        }

    }
    private void validateUserAddress()
    {
        if(userAddress.isEmpty())
        {
            throw new IllegalStateException("Invalid User Address");
        }

    }


    public CargoInfoNotification build(){
        validateTransportType();
        validateDistanceInfo();
        validateCargoName();
        validateUserName();
        validateUserAddress();
        CargoInfoNotification notification = new CargoInfoNotification();
        notification.setTransportType(this.transportType);
        notification.setDistanceInfo(this.distanceInfo);
        notification.setCargoInfo(this.furnitureInfo,this.cargoName);
        notification.setUserName(this.userName);
        notification.setUserAddress(this.userAddress);
        notification.setTimeStamp(this.timeStamp);
        return notification;
    }
}
