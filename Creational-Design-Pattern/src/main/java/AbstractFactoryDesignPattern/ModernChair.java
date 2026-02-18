package AbstractFactoryDesignPattern;

import Utils.ModernFamilyInfo;

public class  ModernChair implements IChair {
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
