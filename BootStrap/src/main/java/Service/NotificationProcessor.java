package Service;

import BuilderDesignPattern.CargoNotificationBuilder;
import BuilderDesignPattern.TransportNotificationBuilder;
import Util.INotificationProcessor;
import Utils.*;

public class NotificationProcessor implements INotificationProcessor {
    private final NotificationService notificationService;
    private final StorageService storageService;

    public NotificationProcessor(NotificationService service, StorageService storage) {
        this.notificationService = service;
        this.storageService = storage;
    }

    @Override
    public void processor(JsonObj jsonObj) {

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

        // Map Domain Obj to respective domain business Objects
        DomainObj domainObj = domainMapper.map(jsonObj);
        UserInfo userInfoObj = domainObj.getUserInfo();
        AddressInfo addressInfoObj = domainObj.getAddressInfoObj();
        CargoInfo cargoInfoObj = domainObj.getCargoInfoObj();
        CurrentTimeService timeService = new CurrentTimeService();

        String timeStamp = timeService.getTimeStamp();

        // Notification Director
        NotificationBuilder notificationBuilder = new NotificationBuilder(
                timeStamp,
                userInfoObj,
                addressInfoObj,
                cargoInfoObj
        );

        // Notification Builder
        Builder<CargoInfoNotification> cargoNotificationBuilder = new CargoNotificationBuilder();
        Builder<TransportInfoNotification> transportNotificationBuilderBuilder = new TransportNotificationBuilder();

        // Use respective Builders to build Notification
        CargoInfoNotification cargoNotification = notificationBuilder.cargoInfoNotificationBuilder(cargoNotificationBuilder);
        TransportInfoNotification transportNotification = notificationBuilder.transportInfoNotificationBuilder(transportNotificationBuilderBuilder);

        // Provide these for notification service to push them for respective business components
        notificationService.pushCargoNotification(cargoNotification);
        notificationService.pushTransportNotification(transportNotification);

        storageService.increment(cargoParser.getFamilyName(jsonObj.getCargo()), cargoParser.getFurnitureName(jsonObj.getCargo()));

    }
}
