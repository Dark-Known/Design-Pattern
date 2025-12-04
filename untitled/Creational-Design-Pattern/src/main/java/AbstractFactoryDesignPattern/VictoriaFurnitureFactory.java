package AbstractFactoryDesignPattern;

import Service.SalesCounterService;

import java.time.Instant;

public class VictoriaFurnitureFactory extends FurnitureFamilyFactory{
    private final String timeStamp;
    private SalesCounterService chairCounterService;
    private SalesCounterService sofaCounterService;

    public VictoriaFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();
        this.chairCounterService=new SalesCounterService();
        this.sofaCounterService=new SalesCounterService();
    }
    @Override
    public IChair createChair() {
        chairCounterService.increment();
        return new VictoriaChair();
    }

    @Override
    public int totalChairSold() {
        return chairCounterService.getCount();
    }

    @Override
    public ISofa createSofa() {
        sofaCounterService.increment();
        return new VictoriaSofa();
    }

    @Override
    public int totalSofaSold() {
        return sofaCounterService.getCount();
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