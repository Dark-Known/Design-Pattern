import Service.JsonDataLoader;
import Service.NotificationProcessor;
import Service.NotificationService;
import Service.StorageService;
import Util.INotificationProcessor;
import Utils.FamilyRegistry;
import Utils.INotificationService;
import Utils.JsonObj;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Load Json Data
        JsonDataLoader jsonDataLoader = new JsonDataLoader();
        ArrayList<JsonObj> responseQueue = jsonDataLoader.loadData();

        // In Memory Units
        FamilyRegistry familyRegistry = new FamilyRegistry();

        // Instantiate Storage Service
        StorageService storage = new StorageService(familyRegistry);

        // Instantiate Notification Service and Processor
        INotificationService notificationService = new NotificationService();
        INotificationProcessor processor = new NotificationProcessor(
                notificationService,
                storage
        );
        responseQueue.forEach((JsonObj res) -> {
            try {
                processor.processor(res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });


    }
}