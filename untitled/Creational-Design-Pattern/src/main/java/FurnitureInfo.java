public class FurnitureInfo {
    private final String manfName;
    private final String manfDate;
    private final int unitsSold;
    private final String materialUsed;

    FurnitureInfo(String manfName, String manfDate,
                  String materialUsed, int unitsSold )
    {
        this.manfName=manfName;
        this.manfDate=manfDate;
        this.unitsSold=unitsSold;
        this.materialUsed=materialUsed;
    }
    public String getManfName()
    {
        return this.manfName;
    }
    public String getManfDate()
    {
        return this.manfDate;
    }
    public int getUnitsSold()
    {
        return this.unitsSold;
    }
    public String getMaterialUsed()
    {
        return this.materialUsed;
    }

}
