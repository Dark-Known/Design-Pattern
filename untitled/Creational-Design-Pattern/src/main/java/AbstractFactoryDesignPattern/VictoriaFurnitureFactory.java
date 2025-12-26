package AbstractFactoryDesignPattern;

import InformationObject.UnitsRegistry;
import InformationObject.InMemoryVictoriaFamilyUnits;

import java.time.Instant;

public class VictoriaFurnitureFactory extends FurnitureFamilyFactory{
    private final String timeStamp;
    public VictoriaFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();

    }
    @Override
    public IChair createChair() {
        return new VictoriaChair();
    }



    @Override
    public ISofa createSofa() {
        return new VictoriaSofa();
    }



    @Override
    public FurnitureInfo getFamilyInfo() {
        String manfName= VictoriaFamilyInfo.MANF_NAME.getName();
        String manfAddress= VictoriaFamilyInfo.MANF_ADD.getName();
        String materialUsed= VictoriaFamilyInfo.MATERIAL.getName();

        String[] splitArr = timeStamp.split("T");
        String manfDate= splitArr[0];

        FurnitureInfo furnitureInfo= new FurnitureInfo(manfName,manfAddress,materialUsed,manfDate);

        return furnitureInfo;
    }
}