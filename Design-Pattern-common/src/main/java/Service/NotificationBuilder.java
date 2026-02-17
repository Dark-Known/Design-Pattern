package Service;

import Utils.*;

public class NotificationBuilder {

    private final String timeStamp;
    private final UserInfo userInfoObj;
    private final AddressInfo addressInfoObj;
    private final CargoInfo cargoInfoObj;

    public NotificationBuilder(String timeStamp, UserInfo userInfoObj,
                               AddressInfo addressInfoObj, CargoInfo cargoInfoObj)
    {
        this.timeStamp = timeStamp;
        this.userInfoObj = userInfoObj;
        this.addressInfoObj = addressInfoObj;
        this.cargoInfoObj = cargoInfoObj;
    }
    public CargoInfoNotification cargoInfoNotificationBuilder(Builder<CargoInfoNotification> cargoNotificationBuilder)
    {
        return constructCargoNotificationBuilder(cargoNotificationBuilder).build();
    }
    public TransportInfoNotification transportInfoNotificationBuilder(Builder<TransportInfoNotification> transportNotificationBuilder)
    {
            return constructTransportNotificationBuilder(transportNotificationBuilder).build();
    }
    private Builder<CargoInfoNotification> constructCargoNotificationBuilder(Builder<CargoInfoNotification>
                                                                                     cargoNotificationBuilder)
    {
        return cargoNotificationBuilder.setTransportType(cargoInfoObj.getTransportType()).
                setDistanceInfo(cargoInfoObj.getDistanceInfo()).
                setCargoInfo(cargoInfoObj.getFurnitureInfoObj(), cargoInfoObj.getCargoName()).
                setUserName(userInfoObj.getUserName()).
                setUserAddress(userInfoObj.getUserAddress()).
                setTimeStamp(timeStamp);
    }
    private Builder<TransportInfoNotification> constructTransportNotificationBuilder
            (Builder<TransportInfoNotification> transportNotificationBuilder)
    {
        return transportNotificationBuilder.setUserName(userInfoObj.getUserName()).
                setUserAddress(userInfoObj.getUserAddress()).
                setTransportType(cargoInfoObj.getTransportType()).
                setSourceAddress(addressInfoObj.getSourceAddress()).
                setDestAddress(addressInfoObj.getDestAddress()).
                setDistanceInfo(cargoInfoObj.getDistanceInfo()).
                setTimeStamp(timeStamp);

    }
}


