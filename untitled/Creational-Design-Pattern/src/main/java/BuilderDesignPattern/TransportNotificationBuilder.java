package BuilderDesignPattern;

import AbstractFactoryDesignPattern.CargoInfo;

public class TransportNotificationBuilder implements Builder {
    private TransportInfoNotification notification;

    @Override
    public Builder reset() {
        this.notification= new TransportInfoNotification();
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
        return this;
    }

    @Override
    public Builder setUserName(String userName) {

        notification.setUserName(userName);
        return this;

    }

    @Override
    public Builder setUserAddress(String userAddress) {
        notification.setUserAddress(userAddress);
        return this;
    }

    @Override
    public Builder setSourceAddress(String sourceAddress) {
        notification.setSourceAddress(sourceAddress);
        return this;
    }

    @Override
    public Builder setDestAddress(String destAddress) {
        notification.setDestAddress(destAddress);
        return this;
    }

    @Override
    public Builder setTimeStamp(String timeStamp) {
        notification.setTimeStamp(timeStamp);
        return this;
    }
    public TransportInfoNotification build(){
        return this.notification;
    }
}
