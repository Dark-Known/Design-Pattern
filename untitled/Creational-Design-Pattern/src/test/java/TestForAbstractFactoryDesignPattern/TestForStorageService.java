package TestForAbstractFactoryDesignPattern;

import InformationObject.FamilyRegistry;
import Service.StorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestForStorageService {
    private  StorageService storageService;
    private  FamilyRegistry familyRegistry;

    @BeforeEach
    void setUpStorage(){
        familyRegistry= new FamilyRegistry();
        storageService=new StorageService(familyRegistry);

    }

    @Test
    void shouldReturnFourModernChairUnitsSold(){
        String familyName= "Modern";
        String furnitureType= "Chair";
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        Assertions.assertEquals(4,storageService.getSoldUnits(familyName,furnitureType));

    }

    @Test
    void shouldReturnFourModernSofaUnitsSold(){
        String familyName= "Modern";
        String furnitureType= "sofa";
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        Assertions.assertEquals(4,storageService.getSoldUnits(familyName,furnitureType));

    }
    @Test
    void shouldReturnFourVictoriaChairUnitsSold(){
        String familyName= "Victoria";
        String furnitureType= "sofa";
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        Assertions.assertEquals(4,storageService.getSoldUnits(familyName,furnitureType));

    }
    @Test
    void shouldReturnFourVictoriaSofaUnitsSold(){
        String familyName= "Victoria";
        String furnitureType= "sofa";
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        storageService.increment(familyName,furnitureType);
        Assertions.assertEquals(4,storageService.getSoldUnits(familyName,furnitureType));

    }
}
