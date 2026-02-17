package TestForBuilderDesignPattern;

import Utils.FurnitureInfo;
import BuilderDesignPattern.CargoNotificationBuilder;
import Service.CurrentTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestForCargoNotificationBuilder {
    private CargoNotificationBuilder notificationBuilder;
    private FurnitureInfo furnitureInfo;
    private String userName;
    private String userAddress;
    private String timeStamp;


    @BeforeEach
    void setUp(){
        notificationBuilder=new CargoNotificationBuilder();
        timeStamp= CurrentTimeService.getTimeStamp();
        furnitureInfo= new FurnitureInfo("manfName1",
                "manfAddress1","cotton","12345");
    }

    @Test
    void resultShouldBeInvalidTransportType(){
         String transportType=" ";
         int distanceInfo=11;
         String cargoName="cargo1";
         String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                setUserName(userName).
                    setUserAddress(userAddress).
                setCargoInfo(furnitureInfo,cargoName).
                setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Transport Type",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTransportTypeWithNullAsTransportType(){
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Transport Type",exception.getMessage());

    }
    @Test
    void resultShouldBeInvalidDistanceInfo(){
        String transportType="Transport1 ";
        int distanceInfo=9;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Distance Information",exception.getMessage());

    }
    @Test
    void resultShouldBeInvalidFurnitureInfo(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(null,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Furniture Information",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidCargoName(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Cargo Name",exception.getMessage());

    }
    @Test
    void resultShouldBeInvalidCargoNameWithNullAsCargoName(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,null).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid Cargo Name",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserName(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName=" ";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid User Name",exception.getMessage());

    }
    @Test
    void resultShouldBeInvalidUserNameWithNullAsUserName(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid User Name",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserAddress(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress=" ";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid User Address",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserAddressWithNullAsUserAddress(){
        String transportType="Transport Type";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(timeStamp).build();
        });
        Assertions.assertEquals("Invalid User Address",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTimeStamp(){
        String transportType="Transport1 ";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp("").build();
        });
        Assertions.assertEquals("Invalid Time Stamp",exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTimeStampWithNullAsTimeStamp(){
        String transportType="Transport1 ";
        int distanceInfo=11;
        String cargoName="cargo1";
        String userName="user1";
        String userAddress="userAddress1";
        IllegalStateException exception=Assertions.assertThrows(IllegalStateException.class,()->{
            notificationBuilder.
                    setTransportType(transportType).
                    setDistanceInfo(distanceInfo).
                    setUserName(userName).
                    setUserAddress(userAddress).
                    setCargoInfo(furnitureInfo,cargoName).
                    setTimeStamp(null).build();
        });
        Assertions.assertEquals("Invalid Time Stamp",exception.getMessage());

    }






}
