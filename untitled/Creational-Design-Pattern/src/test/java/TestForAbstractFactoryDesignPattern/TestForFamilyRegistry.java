package TestForAbstractFactoryDesignPattern;

import InformationObject.FamilyRegistry;
import InformationObject.InMemoryFamily;
import InformationObject.InMemoryFamilyUnits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestForFamilyRegistry {
    private FamilyRegistry familyRegistry;

    @BeforeEach
    void setUpInMemory()
    {
        familyRegistry= new FamilyRegistry();

    }

    @Test
    void shouldReturnModernFamilyRegistry(){
        Assertions.assertEquals(
                InMemoryFamily.class
                ,
                familyRegistry.getFamily("modern").getClass()
        );
    }

}
