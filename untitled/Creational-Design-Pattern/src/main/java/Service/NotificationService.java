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


            // extract furniture name , furniture type
            String furnitureName,furnitureFamilyName;
            String[] tempCargoStrArr=cargoInfoObj.getCargoName().split(" ");
            furnitureName=tempCargoStrArr[1];
            furnitureFamilyName=tempCargoStrArr[0];
            // get furniture family using furniture family Selector
            FamilySelector selector= new FamilySelector(furnitureFamilyName);
            FurnitureFamilyFactory familyFactory=selector.getFamilyFactory();
            ModernFurnitureFactory modernFurnitureFactory=new ModernFurnitureFactory();

            int modernChairCount= modernFurnitureFactory.totalChairSold();
            int modernSofaCount=modernFurnitureFactory.totalSofaSold();
            
            VictoriaFurnitureFactory victoriaFurnitureFactory=new VictoriaFurnitureFactory();

            int victoriaChairCount= victoriaFurnitureFactory.totalChairSold();
            int victoriaSofaCount = victoriaFurnitureFactory.totalSofaSold();



            // extract furnitureInfo using selector
            FurnitureInfo furnitureInfo= selector.getFamilyInfo();
            // create furniture for specific family using furniture family selector and furniture typeName
            FurnitureSelector furnitureSelector= new FurnitureSelector(furnitureName,familyFactory);

            furnitureSelector.getFurniture();

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