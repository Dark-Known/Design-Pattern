package org.example1;

import org.example1.FactoryDesignPattern.TransportFactorySelector;
import org.example1.FactoryDesignPattern.VehicleFactory;

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