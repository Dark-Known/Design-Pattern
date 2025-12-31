package AbstractFactoryDesignPattern;

public class FurnitureInfo {
    private final String manfName;
    private final  String manfAddress;
    private final String materialUsed;
    private final String manfDate;


    public FurnitureInfo(String manfName, String manfAddress,
                         String materialUsed, String manfDate) {

        validateManfName(manfName);
        validateManfAddress(manfAddress);
        validateMaterialUsed(materialUsed);
        this.manfName = manfName;
        this.manfAddress = manfAddress;
        this.materialUsed = materialUsed;
        this.manfDate = manfDate;
    }

    private void validateManfName(String manfName){
        if(manfName.isEmpty())
        {
            throw new IllegalStateException("Invalid Manufacturer name");
        }
    }
    private void validateManfAddress(String manfAddress){
        if(manfAddress.isEmpty())
        {
            throw new IllegalStateException("Invalid Manufacturer Address");
        }
    }
    private void validateMaterialUsed(String materialUsed){
        if(materialUsed.isEmpty())
        {
            throw new IllegalStateException("Invalid Material Used");
        }
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
