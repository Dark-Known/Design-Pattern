package AbstractFactoryDesignPattern;

import InformationObject.CounterServiceRegistry;
import InformationObject.InMemoryVictoriaFamilyUnits;
import Service.SalesCounterService;

import java.time.Instant;

public class VictoriaFurnitureFactory extends FurnitureFamilyFactory{
    private final String timeStamp;
    private InMemoryVictoriaFamilyUnits victoriaFamilyUnit= CounterServiceRegistry.getVictoriaFamilyRegistry();
    public VictoriaFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();

    }
    @Override
    public IChair createChair() {
        victoriaFamilyUnit.incrementChairCount();
        return new VictoriaChair();
    }

    @Override
    public int totalChairSold() {
        return victoriaFamilyUnit.totalChairSold();
    }

    @Override
    public ISofa createSofa() {
        victoriaFamilyUnit.incrementSofaCount();
        return new VictoriaSofa();
    }

    @Override
    public int totalSofaSold() {
        return victoriaFamilyUnit.totalSofaSold();
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