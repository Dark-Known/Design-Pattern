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

            isValid(furnitureType);
            FurnitureInfoEnum furnitureName = FurnitureInfoEnum.valueOf(furnitureType.toUpperCase());
            ICounter counter = furnitureCounterRegistry.get(furnitureName);
            counter.increment();



    }

    @Override
    public int getTotalUnitSold(String furnitureType) {
        isValid(furnitureType);
            FurnitureInfoEnum furnitureName = FurnitureInfoEnum.valueOf(furnitureType.toUpperCase());
            ICounter counter = furnitureCounterRegistry.get(furnitureName);
            return counter.getCount();


    }

    private void isValid(String furnitureType)
    {
        try{
            FurnitureInfoEnum furnitureName = FurnitureInfoEnum.valueOf(furnitureType.toUpperCase());
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Invalid Furniture Type");
        }
    }
}
