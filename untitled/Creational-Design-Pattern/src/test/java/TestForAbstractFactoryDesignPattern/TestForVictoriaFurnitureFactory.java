package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestForVictoriaFurnitureFactory {

    private final VictoriaFurnitureFactory victoriaFurnitureFactory= new VictoriaFurnitureFactory();


    @Test
    public void resultShouldBeVictoriaChair(){
        IChair actualVictoriaChair= victoriaFurnitureFactory.createChair();
        Assertions.assertEquals(VictoriaChair.class,actualVictoriaChair.getClass());
    }

    @Test
    public void resultShouldBeVictoriaSofa()
    {
        ISofa actualVictoriaSofa= victoriaFurnitureFactory.createSofa();
        Assertions.assertEquals(VictoriaSofa.class,actualVictoriaSofa.getClass());
    }
}
