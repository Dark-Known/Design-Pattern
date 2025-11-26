import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;

public class NotificationServiceWithFM {
    public static void pushNotification(String TransportType) {
        try {
            VehicleFactory factory = TransportFactorySelector.getTransportFactory(TransportType);
            factory.notifyUser();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}