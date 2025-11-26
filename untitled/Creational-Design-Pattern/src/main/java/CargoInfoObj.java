public class CargoInfoObj {
    private final String cargoName;
    private final FurnitureInfoObj furnitureInfoObj;

    CargoInfoObj(String cargoName, FurnitureInfoObj furnitureInfoObj)
    {
        this.cargoName=cargoName;
        this.furnitureInfoObj=furnitureInfoObj;
    }

    public String getCargoName(){
        return this.cargoName;
    }
    public FurnitureInfoObj getFurnitureInfoObj(){
        return this.furnitureInfoObj;
    }

}
