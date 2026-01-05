package AbstractFactoryDesignPattern;

public class VictoriaSofa implements ISofa{
    @Override
    public String getmanfName() {
        return VictoriaFamilyInfo.MANF_NAME.getName();
    }

    @Override
    public String getmanfInfo() {
        return VictoriaFamilyInfo.MANF_ADD.getName();
    }

    @Override
    public int getlegsCount() {
        return VictoriaFamilyInfo.SOFA_LEGS.getValue();
    }

    @Override
    public String getMaterialUsed() {
        return VictoriaFamilyInfo.MATERIAL.getName();
    }
}
