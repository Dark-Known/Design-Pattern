package TestFoFactoryDesignPattern;

import FactoryDesignPattern.TransportFactorySelector;
import FactoryDesignPattern.VehicleFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TestForTransportSelector {

    private final ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
    private final PrintStream originalOutStream= System.out;



    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(tempStream));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOutStream);
    }

    @Test
    void TestForRoadTransportNotificationInNotifyUser()
    {
        try {
            VehicleFactory vehicleFactory = TransportFactorySelector.getTransportFactory("road");
            vehicleFactory.notifyUser();
            String expectedOutput= "Delivering via Road";

            Assertions.assertEquals(expectedOutput,tempStream.toString().trim());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void TestForWaterTransportNotificationInNotifyUser()
    {
        try {
            VehicleFactory vehicleFactory = TransportFactorySelector.getTransportFactory("water");
            vehicleFactory.notifyUser();
            String expectedOutput= "Delivering via Water";

            Assertions.assertEquals(expectedOutput,tempStream.toString().trim());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    @Test
    void TestForAirTransportNotificationInNotifyUser()
    {
        try {
            VehicleFactory vehicleFactory = TransportFactorySelector.getTransportFactory("air");
            vehicleFactory.notifyUser();
            String expectedOutput= "Delivering via Air";

            Assertions.assertEquals(expectedOutput,tempStream.toString().trim());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
