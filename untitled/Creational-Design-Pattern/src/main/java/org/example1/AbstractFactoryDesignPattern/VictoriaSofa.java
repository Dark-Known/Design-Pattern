package org.example1.AbstractFactoryDesignPattern;

public class VictoriaSofa implements ISofa{
    static int unitsSold=0;
    VictoriaSofa(){
        VictoriaSofa.unitsSold=VictoriaSofa.unitsSold+1;
    }
    @Override
    public int getunitsSold() {
        return VictoriaSofa.unitsSold;
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
        return VictoriaFamilyInfo.LEGS.getValue();
    }
}
