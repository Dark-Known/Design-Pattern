package Utils;

public class FurnitureInfo {
    private final String manfName;
    private final String manfAddress;
    private final String materialUsed;
    private final String manfDate;


    public FurnitureInfo(String manfName, String manfAddress,
                         String materialUsed, String manfDate) {

        validateManfName(manfName);
        validateManfAddress(manfAddress);
        validateMaterialUsed(materialUsed);
        validateManfDate(manfDate);
        this.manfName = manfName;
        this.manfAddress = manfAddress;
        this.materialUsed = materialUsed;
        this.manfDate = manfDate;
    }

    private void validateManfName(String manfName) {
        if (manfName == null || manfName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Manufacturer name");
        }
    }

    private void validateManfAddress(String manfAddress) {
        if (manfAddress == null || manfAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Manufacturer Address");
        }
    }

    private void validateMaterialUsed(String materialUsed) {
        if (materialUsed == null || materialUsed.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Material Used");
        }
    }

    private void validateManfDate(String manfDate) {
        if (manfDate == null || manfDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Manufacture Date");
        }

    }

    public String getManfName() {
        return this.manfName;
    }

    public String getManfAddress() {
        return this.manfAddress;
    }

    public String getMaterialUsed() {
        return this.materialUsed;
    }

    public String getManfDate() {
        return this.manfDate;
    }
}
