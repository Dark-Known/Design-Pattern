public class CargoInfo {
    private final String cargoName;
    private final FurnitureInfo furnitureInfoObj;

    CargoInfo(String cargoName, FurnitureInfo furnitureInfoObj)
    {
        this.cargoName=cargoName;
        this.furnitureInfoObj=furnitureInfoObj;
    }

    public String getCargoName(){
        return this.cargoName;
    }
    public FurnitureInfo getFurnitureInfoObj(){
        return this.furnitureInfoObj;
    }

}
