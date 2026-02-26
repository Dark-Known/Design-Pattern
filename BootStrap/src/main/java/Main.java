import Service.*;
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

        // Create extractor & CargoParser
        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();
        CargoParser cargoParser = new CargoParser();

        // Create respective Domain Obj Mappers
        UserMapper userMapper = new UserMapper();
        AddressMapper addressMapper = new AddressMapper();
        CargoInfoMapper cargoInfoMapper = new CargoInfoMapper(extractFamilyInfo, cargoParser);
        DomainMapper domainMapper = new DomainMapper(
                userMapper, addressMapper, cargoInfoMapper
        );

        // Instantiate Time Service
        CurrentTimeService timeService = new CurrentTimeService();


        //Instantiate Validator Service
//        JsonValidator validateJson = new JsonValidator();


        // Instantiate Notification Service and Processor
        INotificationService notificationService = new NotificationService();
        INotificationProcessor processor = new NotificationProcessor(
                notificationService,
                storage,
                domainMapper,
                cargoParser,
                timeService
        );


        responseQueue.forEach((JsonObj res) -> {
            try {

//                    validateJson.validate(res);
                    processor.processor(res);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        });


    }


}