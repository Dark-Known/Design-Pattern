package AbstractFactoryDesignPattern;

import java.time.Instant;

public class ModernFurnitureFactory extends FurnitureFamilyFactory {
    private final String timeStamp;

    public ModernFurnitureFactory()
    {
        this.timeStamp= Instant.now().toString();
    }

    @Override
    public IChair createChair() {
        return new ModernChair();

    }


    @Override
    public ISofa createSofa() {
        return new ModernSofa();
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
