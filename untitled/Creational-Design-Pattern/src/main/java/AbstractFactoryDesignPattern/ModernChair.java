package AbstractFactoryDesignPattern;

public class ModernChair implements IChair{
    static int unitsSold=0;
    ModernChair(){
        ModernChair.unitsSold=ModernChair.unitsSold+1;

    }
    @Override
    public int getunitsSold() {
        return ModernChair.unitsSold;
    }

    @Override
    public String getmanfName() {
        return ModernFamilyInfo.MANF_NAME.getName();
    }

    @Override
    public String getmanfInfo() {
        return ModernFamilyInfo.MANF_ADD.getName();
    }

    @Override
    public int getlegsCount() {
        return ModernFamilyInfo.CHAIR_LEGS.getValue();
    }

    @Override
    public String getMaterialUsed() {
        return ModernFamilyInfo.MATERIAL.getName();
    }


}
