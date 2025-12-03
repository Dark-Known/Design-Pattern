package AbstractFactoryDesignPattern;

public class FurnitureInfo {
    private final String manfName;
    private final  String manfAddress;
    private final String materialUsed;
    private final String manfDate;


    public FurnitureInfo(String manfName, String manfAddress,
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

    public String toString(){
        return " "+'\n'+"{"+'\n'+
                "Manufacturer Name :"+manfName+'\n'+
                "Manufacturer Address :"+manfAddress+'\n'+
                "Manufacture Date :"+manfDate+'\n'+
                "Material Used :"+materialUsed+'\n'+
                "}" +'\n';
    }
}
