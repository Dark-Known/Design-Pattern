package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForModernFurnitureFactory {
    private final ModernFurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();

    @Test
    void resultShouldBeModernChair() {
        IChair actualModernChair = modernFurnitureFactory.createChair();
        Assertions.assertEquals(ModernChair.class, actualModernChair.getClass());

    }

    @Test
    void resultShouldBeModernSofa() {
        ISofa actualModernSofa = modernFurnitureFactory.createSofa();
        Assertions.assertEquals(ModernSofa.class, actualModernSofa.getClass());
    }

}
