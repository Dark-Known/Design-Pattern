
import BuilderDesignPattern.CargoNotificationBuilder;
import BuilderDesignPattern.TransportNotificationBuilder;
import Service.*;
import Utils.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Load Json Data
        JsonDataLoader jsonDataLoader = new JsonDataLoader();
        ArrayList<JsonObj> responseQueue =jsonDataLoader.loadData();

        // In Memory Units
        FamilyRegistry familyRegistry= new FamilyRegistry();
        StorageService storage= new StorageService(familyRegistry);
        NotificationService notificationService = new NotificationService();
        NotificationProcessor processor = new NotificationProcessor(
                notificationService,
                storage
        );
        responseQueue.forEach((JsonObj res) -> {
            try {
               processor.processor(res);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

        });











    }
}