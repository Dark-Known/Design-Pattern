package InformationObject;

import java.util.EnumMap;
import java.util.Map;

public class FamilyRegistry {
    private final Map<FamilyInfoEnum,InMemoryFamilyUnits> familyRegistry=new EnumMap<>(FamilyInfoEnum.class);
    public FamilyRegistry(){
        for(FamilyInfoEnum familyMember : FamilyInfoEnum.values())
        {
            familyRegistry.put(familyMember, new InMemoryFamily());
        }
    }
    public InMemoryFamilyUnits getFamily(String familyName)
    {
        isValid(familyName);
       FamilyInfoEnum familyMember = FamilyInfoEnum.valueOf(familyName.toUpperCase());
       return familyRegistry.get(familyMember);
    }
    private void isValid(String familyName)
    {
        try {
            FamilyInfoEnum.valueOf(familyName.toUpperCase());
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid family Name");
        }

    }


}
