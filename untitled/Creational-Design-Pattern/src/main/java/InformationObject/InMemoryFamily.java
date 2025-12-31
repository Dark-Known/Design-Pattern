package InformationObject;

import Service.ICounter;
import Service.SalesCounterService;

import java.util.EnumMap;
import java.util.Map;

public class InMemoryFamily implements InMemoryFamilyUnits{
    private final Map<FurnitureInfoEnum, ICounter> furnitureCounterRegistry=
            new EnumMap<>(FurnitureInfoEnum.class);

    //Initialise Enum-map
    public InMemoryFamily(){
        for(FurnitureInfoEnum furnitureType : FurnitureInfoEnum.values())
        {
            furnitureCounterRegistry.put(furnitureType,new SalesCounterService());
        }
    }
    @Override
    public void incrementUnit(String furnitureType) {
        try {
            FurnitureInfoEnum furnitureName = FurnitureInfoEnum.valueOf(furnitureType.toUpperCase());
            ICounter counter = furnitureCounterRegistry.get(furnitureName);
            counter.increment();
        }
        catch(IllegalStateException e)
        {
            throw new IllegalStateException("Invalid Counter Type");
        }

    }

    @Override
    public int getTotalUnitSold(String furnitureType) {
        try {
            FurnitureInfoEnum furnitureName = FurnitureInfoEnum.valueOf(furnitureType.toUpperCase());
            ICounter counter = furnitureCounterRegistry.get(furnitureName);
            return counter.getCount();
        }
        catch(IllegalStateException e)
        {
            throw new IllegalStateException("Invalid Counter Type");
        }

    }
}
