package AbstractFactoryDesignPattern;

import InformationObject.CounterServiceRegistry;
import InformationObject.InMemoryModernFamilyUnits;
import Service.SalesCounterService;

import java.time.Instant;

public class ModernFurnitureFactory extends FurnitureFamilyFactory {
    private final String timeStamp;
    private InMemoryModernFamilyUnits modernFamilyUnit= CounterServiceRegistry.getModernFamilyRegistry();

    public ModernFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();
    }

    @Override
    public IChair createChair() {

        modernFamilyUnit.incrementChairCount();
        return new ModernChair();

    }

    @Override
    public int totalChairSold() {
        return modernFamilyUnit.totalChairSold();
    }

    @Override
    public ISofa createSofa() {
        modernFamilyUnit.incrementSofaCount();
        return new ModernSofa();
    }

    @Override
    public int totalSofaSold() {
        modernFamilyUnit.totalSofaSold();
        return modernFamilyUnit.totalSofaSold();
    }



    @Override
    public FurnitureInfo getFamilyInfo() {
        String manfName= ModernFamilyInfo.MANF_NAME.getName();
        String manfAddress= ModernFamilyInfo.MANF_ADD.getName();
        String materialUsed= ModernFamilyInfo.MATERIAL.getName();

        String[] splitArr = timeStamp.split("T");
        String manfDate= splitArr[0];

        FurnitureInfo furnitureInfo= new FurnitureInfo(manfName,manfAddress,materialUsed,manfDate);

        return furnitureInfo;

    }


}
