package Service;

import Utils.CargoInfo;

public class CargoParser {
    private final String cargoName;
    CargoParser(String cargoName)
    {
        this.cargoName=cargoName;
    }
    public String getFamilyName(){
        // Get Family Name from cargo Name
        // Need to improve robust way to extract family and furniture name"
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[0];

    }
    public String getFurnitureName(){
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[1];
    }
}
