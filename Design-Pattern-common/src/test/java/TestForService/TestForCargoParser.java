package TestForService;

import Service.CargoParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TestForCargoParser {
    private final CargoParser cargoParser = new CargoParser();


    static Stream<Arguments> invalidValues() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n"),
                Arguments.of((Object) null)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"Modern chair", "Modern sofa", "Modern any Furniture"})
    void resultShouldBeModernFamilyName(String cargoName) {
        Assertions.assertEquals("Modern", cargoParser.getFamilyName(cargoName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Victoria chair", "Victoria sofa", "Victoria any Furniture"})
    void resultShouldBeVictoriaFamilyName(String cargoName) {
        Assertions.assertEquals("Victoria", cargoParser.getFamilyName(cargoName));
    }

    @ParameterizedTest
    @ValueSource(strings={"Modern Chair","Victoria Chair","Random Chair"})
    void resultShouldBeChairFurnitureType(String cargoName)
    {
        Assertions.assertEquals("Chair",cargoParser.getFurnitureName(cargoName));

    }


    @ParameterizedTest
    @ValueSource(strings={"Modern sofa","Victoria sofa","Random sofa"})
    void resultShouldBeSofaFurnitureType(String cargoName)
    {
        Assertions.assertEquals("sofa",cargoParser.getFurnitureName(cargoName));
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    void resultShouldBeInvalidCargoName(String cargoName) {

        Assertions.assertAll("Invalid Cargo Name",
                () -> {

                    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                            () -> {
                                cargoParser.getFamilyName(cargoName);
                            });

                    Assertions.assertEquals("Invalid Cargo Name", exception.getMessage());

                },
                () -> {


                    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                            () -> {
                                cargoParser.getFurnitureName(cargoName);
                            });

                    Assertions.assertEquals("Invalid Cargo Name", exception.getMessage());


                }


        );


    }


}
