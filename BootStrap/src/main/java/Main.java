import Service.JsonDataLoader;
import Service.NotificationProcessor;
import Service.NotificationService;
import Service.StorageService;
import Utils.FamilyRegistry;
import Utils.JsonObj;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Load Json Data
        JsonDataLoader jsonDataLoader = new JsonDataLoader();
        ArrayList<JsonObj> responseQueue = jsonDataLoader.loadData();

        // In Memory Units
        FamilyRegistry familyRegistry = new FamilyRegistry();
        StorageService storage = new StorageService(familyRegistry);
        NotificationService notificationService = new NotificationService();
        NotificationProcessor processor = new NotificationProcessor(
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