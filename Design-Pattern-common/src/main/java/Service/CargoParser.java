package Service;

import Utils.CargoInfo;

public class CargoParser {

    public String getFamilyName(String cargoName){
        // Get Family Name from cargo Name
        // Need to improve robust way to extract family and furniture name"
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[0];

    }
    public String getFurnitureName(String cargoName){
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[1];
    }
}
