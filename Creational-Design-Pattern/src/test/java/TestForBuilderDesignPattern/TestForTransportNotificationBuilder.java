package TestForBuilderDesignPattern;

import BuilderDesignPattern.TransportNotificationBuilder;
import Service.CurrentTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestForTransportNotificationBuilder {
    TransportNotificationBuilder notificationBuilder;
    private String timeStamp;

    @BeforeEach
    void setUp() {
        notificationBuilder = new TransportNotificationBuilder();
        timeStamp = CurrentTimeService.getTimeStamp();
    }

    @Test
    void resultShouldBeInvalidTransportType() {
        String transportType = " ";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Transport Type", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTransportTypeWithNullAsTransportType() {
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Transport Type", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidDistanceInfo() {
        String transportType = "Transport Type 1";
        int distanceInfo = 9;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Distance Information", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserName() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = " ";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid User Name", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserNameWithNullAsUserName() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid User Name", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserAddress() {
        String transportType = "Transport 1 ";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid User Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidUserAddressWithNullAsUserAddress() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";

        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid User Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidSourceAddress() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Source Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidSourceAddressWithNullAsSourceAddress() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String destAddress = "destAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Source Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidDestAddress() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Destination Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidDestAddressWithNullAsDestAddress() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).setTimeStamp(timeStamp).build();
        });

        Assertions.assertEquals("Invalid Destination Address", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTimeStamp() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp("").build();
        });

        Assertions.assertEquals("Invalid Time Stamp", exception.getMessage());

    }

    @Test
    void resultShouldBeInvalidTimeStampWithNullAsTimestamp() {
        String transportType = "Transport 1";
        int distanceInfo = 11;
        String userName = "user1";
        String userAddress = "userAddress1";
        String sourceAddress = "sourceAddress1";
        String destAddress = "destAddress";
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> {
            notificationBuilder.setTransportType(transportType).setDistanceInfo(distanceInfo).
                    setUserName(userName).setUserAddress(userAddress).setSourceAddress(sourceAddress).
                    setDestAddress(destAddress).setTimeStamp(null).build();
        });

        Assertions.assertEquals("Invalid Time Stamp", exception.getMessage());

    }
}
