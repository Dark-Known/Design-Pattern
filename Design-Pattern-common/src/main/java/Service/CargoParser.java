package Service;

public class CargoParser {

    private void validateCargoName(String cargoName)
    {
        if(cargoName==null || cargoName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid Cargo Name");
        }
    }
    public String getFamilyName(String cargoName) {
        // Get Family Name from cargo Name
        // Need to improve robust way to extract family and furniture name"

        validateCargoName(cargoName);
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[0];

    }

    public String getFurnitureName(String cargoName) {

        validateCargoName(cargoName);
        String[] tempSplitArr = cargoName.split(" ");
        return tempSplitArr[1];
    }
}
