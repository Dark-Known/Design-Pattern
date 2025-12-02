import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureFamilyFactory;
import AbstractFactoryDesignPattern.FurnitureInfo;
import AbstractFactoryDesignPattern.FurnitureSelector;
import BuilderDesignPattern.*;
import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;

public class NotificationService {
    private final String timeStamp;
    private final String  transportType;
    private final UserInfo userInfoObj;
    private final AddressInfo addressInfoObj;
    private final CargoInfo cargoInfoObj;
    private final FurnitureInfo furnitureInfoObj;
    private final int distanceInfo;

    public NotificationService(String timeStamp, String transportType, UserInfo userInfoObj, AddressInfo addressInfoObj, CargoInfo cargoInfoObj, FurnitureInfo furnitureInfoObj, int distanceInfo) {
        this.timeStamp = timeStamp;
        this.transportType = transportType;
        this.userInfoObj = userInfoObj;
        this.addressInfoObj = addressInfoObj;
        this.cargoInfoObj = cargoInfoObj;
        this.furnitureInfoObj = furnitureInfoObj;
        this.distanceInfo = distanceInfo;
    }


    public void pushNotification(String TransportType,String cargoName) {
        try {
            // notify user with their transport type
            VehicleFactory vehiclefactory = TransportFactorySelector.getTransportFactory(TransportType);
            vehiclefactory.notifyUser();
            CargoInfoNotification cargoNotification=buildCargoNotification(timeStamp,transportType,
                                                                            distanceInfo,cargoInfoObj);
            TransportInfoNotification transportNotification= buildTransportNotification(timeStamp,transportType,
                                                                                        userInfoObj,addressInfoObj);



            // extract furniture name , furniture type
            String furnitureName,furnitureFamilyName;
            String[] tempCargoStrArr=cargoName.split(" ");
            furnitureName=tempCargoStrArr[1];
            furnitureFamilyName=tempCargoStrArr[0];
            // get furniture family using furniture vehiclefactory
            FamilySelector selector= new FamilySelector(furnitureFamilyName);
            FurnitureFamilyFactory familyFactory=selector.getFamilyFactory();
            // extract furnitureInfo using selector
            FurnitureInfo furnitureInfo= selector.getFamilyInfo();
            // create furniture for specific family using furniture vehiclefactory and furniture typeName
            FurnitureSelector furnitureSelector= new FurnitureSelector(furnitureName,familyFactory);
            furnitureSelector.getFurniture();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public CargoInfoNotification buildCargoNotification(String timeStamp, String transportType,
                                                        int distanceInfo , CargoInfo cargoInfo)
    {
        Builder<CargoInfoNotification> notificationBuilder= new CargoNotificationBuilder().
                                                                setTimeStamp(timeStamp).
                                                                setTransportType(transportType).
                                                                setDistanceInfo(distanceInfo).
                                                                setCargoInfo(cargoInfo.getFurnitureInfoObj(), cargoInfo.getCargoName());
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