package Service;

import InformationObject.FamilyRegistry;
import InformationObject.InMemoryFamilyUnits;

public class StorageService {
    FamilyRegistry familyRegistry;
    public StorageService(FamilyRegistry familyRegistry)
    {
        this.familyRegistry=familyRegistry;
    }

    public void increment(String familyName, String furnitureType)
    {
        InMemoryFamilyUnits family= familyRegistry.getFamily(familyName);
        family.incrementUnit(furnitureType);
    }
    public int getSoldUnits(String familyName, String furnitureType)
    {
        InMemoryFamilyUnits family= familyRegistry.getFamily(familyName);
        return family.getTotalUnitSold(furnitureType);
    }





}
