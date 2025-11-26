package AbstractFactoryDesignPattern;

enum ModernFamilyInfo {
    MANF_NAME("Modern COMPANY"),
    MANF_ADD("Modern ADDRESS"),
    MATERIAL("silk"),
    LEGS(4);
    private  String name;
    private int count;
     ModernFamilyInfo(String name)
    {
        this.name= name;
    }
     ModernFamilyInfo(int count)
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
