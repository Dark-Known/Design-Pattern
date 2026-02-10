package Service;

import BuilderDesignPattern.CargoNotificationBuilder;
import BuilderDesignPattern.TransportNotificationBuilder;
import Util.INotificationProcessor;
import Utils.*;

import javax.management.Notification;

public class NotificationProcessor implements INotificationProcessor {
    private final NotificationService notificationService;
    private final StorageService storageService;

    public NotificationProcessor(NotificationService service, StorageService storage)
    {
        this.notificationService= service;
        this.storageService= storage;
    }

    @Override
    public void processor(JsonObj jsonObj) {
        FieldMapper fieldMapper = new FieldMapper(jsonObj);

        // Map Domain Obj to respective domain business Objects
        DomainObj domainObj=fieldMapper.map();
        UserInfo userInfoObj=domainObj.getUserInfo();
        AddressInfo addressInfoObj = domainObj.getAddressInfoObj();
        CargoInfo cargoInfoObj=domainObj.getCargoInfoObj();
        String timeStamp= CurrentTimeService.getTimeStamp();

        // Notification Director
        NotificationBuilder notificationBuilder = new NotificationBuilder(
                timeStamp,
                userInfoObj,
                addressInfoObj,
                cargoInfoObj
        );

        // Notification Builder
        Builder<CargoInfoNotification> cargoNotificationBuilder= new CargoNotificationBuilder();
        Builder<TransportInfoNotification> transportNotificationBuilderBuilder= new TransportNotificationBuilder();

        // Use respective Builders to build Notification
        CargoInfoNotification cargoNotification= notificationBuilder.cargoInfoNotificationBuilder(cargoNotificationBuilder);
        TransportInfoNotification transportNotification= notificationBuilder.transportInfoNotificationBuilder(transportNotificationBuilderBuilder);

        // Provide these for notification service to push them for respective business components
        notificationService.pushCargoNotification(cargoNotification);
        notificationService.pushTransportNotification(transportNotification);

        CargoParser cargoParser = new CargoParser(jsonObj.getCargo());

        storageService.increment(cargoParser.getFamilyName(),cargoParser.getFurnitureName());

    }
}
