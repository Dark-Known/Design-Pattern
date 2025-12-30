package Service;

import InformationObject.InMemoryUnits;
import InformationObject.UnitsRegistry;

public class RegistrySelector {
    private final UnitsRegistry unitsRegistry;
    RegistrySelector(UnitsRegistry unitsRegistry)
    {
        this.unitsRegistry=unitsRegistry;
    }

    // Enum based method selector
    private enum InMemoryFamilySelector {
        MODERN{
            @Override
            InMemoryUnits getMethod(UnitsRegistry unitsRegistry)
            {
                return unitsRegistry.getModernFamilyRegistry();
            }
        },
        VICTORIA{
            @Override
            InMemoryUnits getMethod(UnitsRegistry unitsRegistry) {
                return unitsRegistry.getVictoriaFamilyRegistry();
            }
        };


        abstract InMemoryUnits getMethod(UnitsRegistry unitsRegistry);
    }

    // Retrieve method signature from enum method selector
    public InMemoryUnits getMemoryUnit(String familyName)
    {
        try {
            return InMemoryFamilySelector.valueOf(familyName).getMethod(unitsRegistry);
        }
        catch(IllegalStateException e)
        {
            throw new IllegalStateException("Family Name invalid");
        }
    }
}
