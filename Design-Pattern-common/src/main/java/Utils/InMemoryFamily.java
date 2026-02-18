package Utils;

import Service.SalesCounterService;

import java.util.EnumMap;
import java.util.Map;

public class InMemoryFamily implements InMemoryFamilyUnits {
    private final Map<FurnitureEnum, ICounter> furnitureCounterRegistry =
            new EnumMap<>(FurnitureEnum.class);

    //Initialise Enum-map
    public InMemoryFamily() {
        for (FurnitureEnum furnitureType : FurnitureEnum.values()) {
            furnitureCounterRegistry.put(furnitureType, new SalesCounterService());
        }
    }

    @Override
    public void incrementUnit(String furnitureType) {

        isValid(furnitureType);
        FurnitureEnum furnitureName = FurnitureEnum.valueOf(furnitureType.toUpperCase());
        ICounter counter = furnitureCounterRegistry.get(furnitureName);
        counter.increment();


    }

    @Override
    public int getTotalUnitSold(String furnitureType) {
        isValid(furnitureType);
        FurnitureEnum furnitureName = FurnitureEnum.valueOf(furnitureType.toUpperCase());
        ICounter counter = furnitureCounterRegistry.get(furnitureName);
        return counter.getCount();


    }

    private void isValid(String furnitureType) {
        try {
            FurnitureEnum furnitureName = FurnitureEnum.valueOf(furnitureType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Furniture Type");
        }
    }
}
