package TestForBuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;
import BuilderDesignPattern.CargoInfoNotification;
import BuilderDesignPattern.CargoNotificationBuilder;
import Service.CurrentTimeService;
import org.junit.jupiter.api.BeforeEach;

public class TestForCargoNotificationBuilder {
    private CargoNotificationBuilder notificationBuilder;
    private String transportType;
    private int distanceInfo;
    private FurnitureInfo furnitureInfo;
    private String cargoName;
    private String userName;
    private String userAddress;
    private String timeStamp;


    @BeforeEach
    void setUp(){
        notificationBuilder=new CargoNotificationBuilder();
        timeStamp= CurrentTimeService.getTimeStamp();
    }


}
