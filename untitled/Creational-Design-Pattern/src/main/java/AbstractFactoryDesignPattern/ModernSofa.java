package AbstractFactoryDesignPattern;

import Service.SalesCounterService;

public class ModernSofa implements ISofa{

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
        return ModernFamilyInfo.SOFA_LEGS.getValue();
    }

    @Override
    public String getMaterialUsed() {
        return ModernFamilyInfo.MATERIAL.getName();
    }
}
