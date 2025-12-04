package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;
import AbstractFactoryDesignPattern.VictoriaFurnitureFactory;
import Service.CurrentTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestForExtractingVictoriaFamilyInfo {
    private final String date = CurrentTimeService.getDate();
    private final FurnitureInfo expectedFurnitureInfoObj= new FurnitureInfo(
            "Victorian COMPANY",
            "Victorian ADDRESS",
            "cotton", date);
    private final VictoriaFurnitureFactory victoriaFurnitureFactory= new VictoriaFurnitureFactory();
    private final FurnitureInfo actualFurnitureInfoObj = victoriaFurnitureFactory.getFamilyInfo();
    @Test
    void testToVerifyGetManfName(){
        String expectedManfName= expectedFurnitureInfoObj.getManfName();
        String ActualManfName= actualFurnitureInfoObj.getManfName();

        Assertions.assertEquals(expectedManfName,ActualManfName);
    }
    @Test
    void testToVerifyGetManfAddress()
    {
        String expectedManfAddress= expectedFurnitureInfoObj.getManfAddress();
        String actualManfAddress= actualFurnitureInfoObj.getManfAddress();

        Assertions.assertEquals(expectedManfAddress,actualManfAddress);
    }

    @Test
    void testToVerifyGetMaterialInfo()
    {
        String expectedMaterialInfo= expectedFurnitureInfoObj.getMaterialUsed();
        String actualMaterialInfo= actualFurnitureInfoObj.getMaterialUsed();

        Assertions.assertEquals(expectedMaterialInfo,actualMaterialInfo);
    }

    @Test
    void testToVerifyGetManfDate()
    {
        String expectedManfDate= expectedFurnitureInfoObj.getManfDate();
        String actualManfDate= actualFurnitureInfoObj.getManfDate();

        Assertions.assertEquals(expectedManfDate,actualManfDate);
    }
}
