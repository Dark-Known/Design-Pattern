package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureFamilyFactory;
import AbstractFactoryDesignPattern.ModernFurnitureFactory;
import AbstractFactoryDesignPattern.VictoriaFurnitureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForFamilySelector {


    @Test
    void ResultShouldBeModernFamilyFactory()
    {

        FamilySelector familySelector= new FamilySelector("modern");
        FurnitureFamilyFactory actualModernFurnitureFactory=familySelector.getFamilyFactory();


        Assertions.assertEquals(ModernFurnitureFactory.class,actualModernFurnitureFactory.getClass());

    }

    @Test
    void ResultShouldBeVictoriaFamilyFactory(){
        FamilySelector familySelector= new FamilySelector("victoria");
        FurnitureFamilyFactory actualVictoriaFurnitureFactory =familySelector.getFamilyFactory();


        Assertions.assertEquals(VictoriaFurnitureFactory.class, actualVictoriaFurnitureFactory.getClass());


    }
}
