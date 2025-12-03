package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class CargoNotificationBuilder implements Builder<CargoInfoNotification>{
    private CargoInfoNotification notification=new CargoInfoNotification();

    @Override
    public Builder<CargoInfoNotification> reset() {
        notification = new CargoInfoNotification();
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setTransportType(String transportType) {
        notification.setTransportType(transportType);
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setDistanceInfo(int distanceInfo) {
        notification.setDistanceInfo(distanceInfo);
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setCargoInfo(FurnitureInfo furnitureInfo,String cargoName) {
        notification.setCargoInfo(furnitureInfo,cargoName);
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserName(String userName) {
        notification.setUserName(userName);
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserAddress(String userAddress) {
        notification.setUserAddress(userAddress);
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
        notification.setTimeStamp(timeStamp);
        return this;
    }

    public CargoInfoNotification build(){
        return notification;
    }
}
