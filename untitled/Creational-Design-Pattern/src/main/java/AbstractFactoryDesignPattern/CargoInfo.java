package AbstractFactoryDesignPattern;

public class CargoInfo {
    private final String manfName;
    private final  String manfAddress;
    private final String materialUsed;
    private final String manfDate;


    public CargoInfo(String manfName, String manfAddress,
                     String materialUsed, String manfDate) {
        this.manfName = manfName;
        this.manfAddress = manfAddress;
        this.materialUsed = materialUsed;
        this.manfDate = manfDate;
    }
    public String getManfName(){
        return this.manfName;
    }
    public String getManfAddress(){
        return this.manfAddress;
    }
    public String getMaterialUsed(){
        return this.materialUsed;
    }
    public String getManfDate(){
        return this.manfDate;
    }
}
