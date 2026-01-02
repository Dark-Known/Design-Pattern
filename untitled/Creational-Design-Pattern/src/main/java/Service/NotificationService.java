package Service;

import AbstractFactoryDesignPattern.*;
import BuilderDesignPattern.*;
import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;
import InformationObject.AddressInfo;
import InformationObject.CargoInfo;
import InformationObject.UserInfo;

public class NotificationService {
    private final String timeStamp;
    private final UserInfo userInfoObj;
    private final AddressInfo addressInfoObj;
    private final CargoInfo cargoInfoObj;

    public NotificationService(String timeStamp, UserInfo userInfoObj,
                               AddressInfo addressInfoObj, CargoInfo cargoInfoObj)
                                {
        this.timeStamp = timeStamp;
        this.userInfoObj = userInfoObj;
        this.addressInfoObj = addressInfoObj;
        this.cargoInfoObj = cargoInfoObj;
    }


    public void pushNotification() {
        try {
            // notify user with their transport type
            VehicleFactory vehiclefactory = TransportFactorySelector.getTransportFactory(cargoInfoObj.getTransportType());
            vehiclefactory.notifyUser();
            // build different notifications using their respective builders
            CargoInfoNotification cargoNotification=buildCargoNotification();
            TransportInfoNotification transportNotification= buildTransportNotification();

            System.out.println("cargo :"+cargoNotification.toString());
            System.out.println("Transport :"+transportNotification.toString());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public CargoInfoNotification buildCargoNotification()
    {
        Builder<CargoInfoNotification> notificationBuilder= new CargoNotificationBuilder().
                                                                setTimeStamp(timeStamp).
                                                                setTransportType(cargoInfoObj.getTransportType()).
                                                                setDistanceInfo(cargoInfoObj.getDistanceInfo()).
                                                                setCargoInfo(cargoInfoObj.getFurnitureInfoObj(), cargoInfoObj.getCargoName()).
                                                                setUserAddress(userInfoObj.getUserAddress()).
                                                                setUserName(userInfoObj.getUserName());
                ;
        return notificationBuilder.build();
    }

    public TransportInfoNotification buildTransportNotification()
    {
        Builder<TransportInfoNotification> notificationBuilder = new TransportNotificationBuilder().
                                                                        setTimeStamp(timeStamp).
                                                                        setDistanceInfo(cargoInfoObj.getDistanceInfo()).
                                                                        setTransportType(cargoInfoObj.getTransportType()).
                                                                        setUserName(userInfoObj.getUserName()).
                                                                        setUserAddress(userInfoObj.getUserAddress()).
                                                                        setSourceAddress(addressInfoObj.getSourceAddress()).
                                                                        setDestAddress(addressInfoObj.getDestAddress());
        return notificationBuilder.build();
    }


}