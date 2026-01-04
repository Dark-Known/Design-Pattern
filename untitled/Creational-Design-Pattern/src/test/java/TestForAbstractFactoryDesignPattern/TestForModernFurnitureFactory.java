package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;

public class TestForModernFurnitureFactory {
    private final ModernFurnitureFactory modernFurnitureFactory=new ModernFurnitureFactory();
    private final  IChair modernChair=modernFurnitureFactory.createChair();

    @Test
    void resultShouldBeModernChair(){
        IChair actualModernChair= modernFurnitureFactory.createChair();
        Assertions.assertEquals(ModernChair.class,actualModernChair.getClass());

    }

    @Test
    void resultShouldBeModernSofa()
    {
        ISofa actualModernSofa= modernFurnitureFactory.createSofa();
        Assertions.assertEquals(ModernSofa.class,actualModernSofa.getClass());
    }

  



}
