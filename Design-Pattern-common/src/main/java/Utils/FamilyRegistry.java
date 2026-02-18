package Utils;

import java.util.EnumMap;
import java.util.Map;

public class FamilyRegistry {
    private final Map<FamilyMembersEnum, InMemoryFamilyUnits> familyRegistry = new EnumMap<>(FamilyMembersEnum.class);

    public FamilyRegistry() {
        for (FamilyMembersEnum familyMember : FamilyMembersEnum.values()) {
            familyRegistry.put(familyMember, new InMemoryFamily());
        }
    }

    public InMemoryFamilyUnits getFamily(String familyName) {
        isValid(familyName);
        FamilyMembersEnum familyMember = FamilyMembersEnum.valueOf(familyName.toUpperCase());
        return familyRegistry.get(familyMember);
    }

    private void isValid(String familyName) {
        try {
            FamilyMembersEnum.valueOf(familyName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid family Name");
        }

    }


}
