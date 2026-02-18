package Service;

import Utils.FamilyMembersEnum;
import Utils.FurnitureInfo;

public class ExtractFamilyInfo {

    private void validateFamilyName(String familyName) {
        if (familyName == null || familyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Family Name");
        }

    }

    private void validateFamilyMemberExistence(String familyName)
    {
        try {
            FamilyMembersEnum.valueOf(familyName.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Family Member doesnt exist");
        }
    }

    public FurnitureInfo getInfo(String familyName) {
        String normalisedName= familyName.trim();
        validateFamilyName(familyName);
        validateFamilyMemberExistence(familyName);
        return FamilyMembersEnum.Info(normalisedName);
    }


}
