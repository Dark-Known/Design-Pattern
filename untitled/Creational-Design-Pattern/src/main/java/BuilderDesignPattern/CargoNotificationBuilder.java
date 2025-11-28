package BuilderDesignPattern;

import AbstractFactoryDesignPattern.CargoInfo;

public class CargoNotificationBuilder implements Builder{
    private CargoInfoNotification notification;

    @Override
    public Builder reset() {
        this.notification = new CargoInfoNotification();
        return this;
    }

    @Override
    public Builder setTransportType(String transportType) {
        notification.setTransportType(transportType);
        return this;
    }

    @Override
    public Builder setDistanceInfo(int distanceInfo) {
        notification.setDistanceInfo(distanceInfo);
        return this;
    }

    @Override
    public Builder setCargoInfo(CargoInfo cargoInfo) {
        notification.setCargoInfo(cargoInfo);
        return this;
    }

    @Override
    public Builder setUserName(String userName) {
        return this;
    }

    @Override
    public Builder setUserAddress(String userAddress) {
        return this;
    }

    @Override
    public Builder setSourceAddress(String sourceAddress) {
        return this;
    }

    @Override
    public Builder setDestAddress(String destAddress) {
        return this;
    }

    @Override
    public Builder setTimeStamp(String timeStamp) {
        notification.setTimeStamp(timeStamp);
        return this;
    }
    public CargoInfoNotification build(){
        return notification;
    }
}
