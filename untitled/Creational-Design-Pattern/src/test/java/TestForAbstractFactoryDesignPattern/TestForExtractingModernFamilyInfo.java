package TestForAbstractFactoryDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;
import AbstractFactoryDesignPattern.ModernFurnitureFactory;
import Service.CurrentTimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForExtractingModernFamilyInfo {
    private final String date =CurrentTimeService.getDate();
    private final  FurnitureInfo expectedFurnitureInfoObj= new FurnitureInfo("Modern COMPANY","Modern ADDRESS",
            "silk",date);
    private final ModernFurnitureFactory modernFurnitureFactory= new ModernFurnitureFactory();
    private final FurnitureInfo actualFurnitureInfoObj = modernFurnitureFactory.getFamilyInfo();






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
//    @Test
//    void ResultShouldBeFourModernChairUnitsSold(){
//        Assertions.assertEquals(4 ,);
//
//
//    }



}
