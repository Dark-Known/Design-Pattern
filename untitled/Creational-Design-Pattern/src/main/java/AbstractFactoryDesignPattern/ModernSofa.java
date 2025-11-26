package AbstractFactoryDesignPattern;

public class ModernSofa implements ISofa{
    static int unitsSold=0;
    ModernSofa()
    {
        ModernSofa.unitsSold=ModernSofa.unitsSold+1;
    }

    @Override
    public int getunitsSold() {
        return ModernSofa.unitsSold;
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
        return ModernFamilyInfo.LEGS.getValue();
    }

    @Override
    public String getMaterialUsed() {
        return ModernFamilyInfo.MATERIAL.getName();
    }
}
