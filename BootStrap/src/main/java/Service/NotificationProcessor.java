package Service;

import BuilderDesignPattern.CargoNotificationBuilder;
import BuilderDesignPattern.TransportNotificationBuilder;
import Util.INotificationProcessor;
import Utils.*;

public class NotificationProcessor implements INotificationProcessor {
    private final INotificationService notificationService;
    private final StorageService storageService;
    private final DomainMapper domainMapper;
    private final CargoParser cargoParser;
    private final CurrentTimeService timeService;

    public NotificationProcessor(INotificationService service, StorageService storage,
                                 DomainMapper domainMapper, CargoParser cargoParser, CurrentTimeService timeService) {
        this.notificationService = service;
        this.storageService = storage;
        this.domainMapper= domainMapper;
        this.cargoParser=cargoParser;
        this.timeService = timeService;
    }

    @Override
    public void processor(JsonObj jsonObj) {



        // Map Domain Obj to respective domain business Objects
        DomainObj domainObj = domainMapper.map(jsonObj);
        NotificationBuilder notificationBuilder = getNotificationBuilder(domainObj);

        // Notification Builder
        Builder<CargoInfoNotification> cargoNotificationBuilder = new CargoNotificationBuilder();
        Builder<TransportInfoNotification> transportNotificationBuilderBuilder = new TransportNotificationBuilder();

        // Use respective Builders to build Notification
        CargoInfoNotification cargoNotification = notificationBuilder.cargoInfoNotificationBuilder(cargoNotificationBuilder);
        TransportInfoNotification transportNotification = notificationBuilder.transportInfoNotificationBuilder(transportNotificationBuilderBuilder);

        // Provide these for notification service to push them for respective business components
        notificationService.pushCargoNotification(cargoNotification);
        notificationService.pushTransportNotification(transportNotification);

        storageService.increment(cargoParser.getFamilyName(jsonObj.getCargo()),
                cargoParser.getFurnitureName(jsonObj.getCargo()));

    }

    private NotificationBuilder getNotificationBuilder(DomainObj domainObj) {
        UserInfo userInfoObj = domainObj.getUserInfo();
        AddressInfo addressInfoObj = domainObj.getAddressInfoObj();
        CargoInfo cargoInfoObj = domainObj.getCargoInfoObj();
        String timeStamp = timeService.getTimeStamp();

        // Notification Director
        return new NotificationBuilder(
                timeStamp,
                userInfoObj,
                addressInfoObj,
                cargoInfoObj
        );
    }
}
