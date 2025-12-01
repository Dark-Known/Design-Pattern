import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureFamilyFactory;
import AbstractFactoryDesignPattern.FurnitureInfo;
import AbstractFactoryDesignPattern.FurnitureSelector;
import BuilderDesignPattern.*;
import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;

public class NotificationService {
    public void pushNotification(String TransportType,String cargoName) {
        try {
            // notify user with their transport type
            VehicleFactory factory = TransportFactorySelector.getTransportFactory(TransportType);
            factory.notifyUser();
            // extract furniture name , furniture type
            String furnitureName,furnitureFamilyName;
            String[] tempCargoStrArr=cargoName.split(" ");
            furnitureName=tempCargoStrArr[1];
            furnitureFamilyName=tempCargoStrArr[0];
            // get furniture family using furniture factory
            FamilySelector selector= new FamilySelector(furnitureFamilyName);
            FurnitureFamilyFactory familyFactory=selector.getFamilyFactory();
            FurnitureInfo cargoInfo= selector.getFamilyInfo();
            // create furniture for specific family using furniture factory and furniture typeName
            FurnitureSelector furnitureSelector= new FurnitureSelector(furnitureName,familyFactory);
            furnitureSelector.getFurniture();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public CargoInfoNotification buildCargoNotification(String timeStamp, String transportType,
                                                        int distanceInfo , FurnitureInfo cargoInfo)
    {
        Builder<CargoInfoNotification> notificationBuilder= new CargoNotificationBuilder().
                                                                setTimeStamp(timeStamp).
                                                                setTransportType(transportType).
                                                                setDistanceInfo(distanceInfo).
                                                                setCargoInfo(cargoInfo);
        return notificationBuilder.build();
    }

    public TransportInfoNotification buildTransportNotification(String timeStamp,String transportType,
                                                                UserInfo userInfoObj,AddressInfo addressInfo)
    {
        Builder<TransportInfoNotification> notificationBuilder = new TransportNotificationBuilder().
                                                                        setTimeStamp(timeStamp).
                                                                        setTransportType(transportType).
                                                                        setUserName(userInfoObj.getUserName()).
                                                                        setUserAddress(userInfoObj.getUserAddress()).
                                                                        setSourceAddress(addressInfo.getSourceAddress()).
                                                                        setDestAddress(addressInfo.getDestAddress());
        return notificationBuilder.build();
    }


}