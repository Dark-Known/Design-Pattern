package AbstractFactoryDesignPattern;

public class VictoriaChair implements IChair{
    static int unitsSold=0;
    VictoriaChair(){
        VictoriaChair.unitsSold=VictoriaChair.unitsSold+1;
    }

    @Override
    public int getunitsSold() {
        return VictoriaChair.unitsSold;
    }

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
        return VictoriaFamilyInfo.CHAIR_LEGS.getValue();
    }

    @Override
    public String getMaterialUsed() {
        return VictoriaFamilyInfo.MATERIAL.getName();
    }
}
