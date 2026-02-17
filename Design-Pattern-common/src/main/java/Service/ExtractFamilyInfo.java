package Service;

import Utils.FamilyMembersEnum;
import Utils.FurnitureInfo;

public class ExtractFamilyInfo {

    private void validateFamilyName(String familyName){
        if(familyName==null || familyName.trim().isEmpty())
        {
            throw new IllegalStateException("Invalid Family Name");
        }
        try
        {
            FamilyMembersEnum.valueOf(familyName.toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Family Member doesnt exist");
        }
    }

    public FurnitureInfo getInfo(String familyName) {
        validateFamilyName(familyName);
        return FamilyMembersEnum.Info(familyName);
    }




}
