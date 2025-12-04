package AbstractFactoryDesignPattern;

import Service.SalesCounterService;

import java.time.Instant;

public class ModernFurnitureFactory extends FurnitureFamilyFactory {
    private final String timeStamp;
    private SalesCounterService chairCounterService;
    private SalesCounterService sofaCounterService;

    public ModernFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();
        this.chairCounterService = new SalesCounterService();
        this.sofaCounterService=new SalesCounterService();
    }

    @Override
    public IChair createChair() {
        chairCounterService.increment();
        return new ModernChair();

    }

    public int getChairsSold(){
        return chairCounterService.getCount();
    }

    @Override
    public ISofa createSofa() {
        sofaCounterService.increment();
        return new ModernSofa();
    }
    public int getSofasSold(){
        return sofaCounterService.getCount();
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
