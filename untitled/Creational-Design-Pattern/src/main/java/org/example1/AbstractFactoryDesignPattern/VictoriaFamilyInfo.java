package org.example1.AbstractFactoryDesignPattern;

 enum VictoriaFamilyInfo {
    MANF_NAME("Victorian COMPANY"),
    MANF_ADD("Victorian ADDRESS"),
    LEGS(4);
    private  String name;
    private int count;
    VictoriaFamilyInfo(String name)
    {
        this.name= name;
    }
    VictoriaFamilyInfo(int count)
    {
        this.count=count;
    }
     public String getName(){
         return this.name;

     }
     public int getValue(){
         return this.count;
     }
}
