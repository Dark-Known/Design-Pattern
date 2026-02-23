package TestForService;

import Service.StorageService;
import Utils.FamilyRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestForStorageService {
    private FamilyRegistry familyRegistry;
    private StorageService storageService;



    @BeforeEach
    void setUpStorage() {
        familyRegistry = new FamilyRegistry();
        storageService = new StorageService(familyRegistry);

    }

    public static Stream<Arguments> argumentStream()
    {
        return Stream.of(
                Arguments.of("Modern", "Chair"),
                Arguments.of("Modern", "Sofa"),
                Arguments.of("Victoria","Chair"),
                Arguments.of("Victoria","Sofa")
        );

    }


    static Stream<Arguments> invalidValues() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n"),
                Arguments.of("Garbage Value")
        );
    }


    @ParameterizedTest
    @MethodSource("argumentStream")
    void shouldReturnFourUnitsStored(String familyName, String furnitureType) {
        storageService.increment(familyName, furnitureType);
        storageService.increment(familyName, furnitureType);
        storageService.increment(familyName, furnitureType);
        storageService.increment(familyName, furnitureType);
        Assertions.assertEquals(4, storageService.getSoldUnits(familyName, furnitureType));

    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    void shouldReturnInvalidFamilyName(String familyName) {
        String furnitureType = "sofa";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    storageService.increment(familyName, furnitureType);
                });
        Assertions.assertEquals("Invalid family Name", exception.getMessage());

    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    void shouldReturnInvalidFurnitureType(String furnitureType) {
        String familyName = "Victoria";

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    storageService.increment(familyName, furnitureType);
                });
        Assertions.assertEquals("Invalid Furniture Type", exception.getMessage());

    }
}
