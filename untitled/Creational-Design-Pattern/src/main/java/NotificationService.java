import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureFamilyFactory;
import AbstractFactoryDesignPattern.FurnitureSelector;
import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;

public class NotificationService {
    public static void pushNotification(String TransportType,String cargoName) {
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
            // create furniture for specific family using furniture factory and furniture typeName
            FurnitureSelector furnitureSelector= new FurnitureSelector(furnitureName,familyFactory);
            furnitureSelector.getFurniture();








        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}