package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class TransportNotificationBuilder implements Builder<TransportInfoNotification> {
    private TransportInfoNotification notification;

    @Override
    public Builder<TransportInfoNotification> reset() {
        this.notification= new TransportInfoNotification();
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setTransportType(String transportType) {
        notification.setTransportType(transportType);
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setDistanceInfo(int distanceInfo) {
        notification.setDistanceInfo(distanceInfo);
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setCargoInfo(FurnitureInfo furnitureInfo) {
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setUserName(String userName) {

        notification.setUserName(userName);
        return this;

    }

    @Override
    public Builder<TransportInfoNotification> setUserAddress(String userAddress) {
        notification.setUserAddress(userAddress);
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setSourceAddress(String sourceAddress) {
        notification.setSourceAddress(sourceAddress);
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setDestAddress(String destAddress) {
        notification.setDestAddress(destAddress);
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setTimeStamp(String timeStamp) {
        notification.setTimeStamp(timeStamp);
        return this;
    }
    public TransportInfoNotification build(){
        return this.notification;
    }
}
