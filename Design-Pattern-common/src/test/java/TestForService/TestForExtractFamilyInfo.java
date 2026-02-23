package TestForService;

import Service.CurrentTimeService;
import Service.ExtractFamilyInfo;
import Utils.FurnitureInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestForExtractFamilyInfo {

    private final CurrentTimeService actualTimeService = new CurrentTimeService();

    private final FurnitureInfo expectedModernFamilyInfo = new FurnitureInfo(
            "Modern COMPANY",
            "Modern ADDRESS",
            "silk",
            actualTimeService.getDate()
    );
    private final FurnitureInfo expectedVictoriaFamilyInfo = new FurnitureInfo(
            "Victorian COMPANY",
            "Victorian ADDRESS",
            "cotton",
            actualTimeService.getDate()
    );


    static Stream<Arguments> invalidValues() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n")
        );
    }


    static Stream<Arguments> modernVariants() {

        return Stream.of(
                Arguments.of("modern"),
                Arguments.of("Modern"),
                Arguments.of("MODERN"),
                Arguments.of(" modern "),
                Arguments.of("  Modern  "),
                Arguments.of("MoDeRn")
        );
    }

    static Stream<Arguments> victoriaVariants() {

        return Stream.of(
                Arguments.of("victoria"),
                Arguments.of("Victoria"),
                Arguments.of("VICTORIA"),
                Arguments.of(" victoria "),
                Arguments.of("  Victoria  "),
                Arguments.of("ViCtOrIa")
        );
    }


    @ParameterizedTest
    @MethodSource("modernVariants")
    void resultShouldBeModernFamilyInfo(String familyName) {
        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();
        FurnitureInfo actualModernFamilyInfo = extractFamilyInfo.getInfo(familyName);

        Assertions.assertEquals(expectedModernFamilyInfo.getClass(), actualModernFamilyInfo.getClass());
        Assertions.assertAll(
                "Modern Family Info Verification",
                () -> {
                    Assertions.assertEquals(expectedModernFamilyInfo.getManfName(),
                            actualModernFamilyInfo.getManfName(),
                            "Miss match in manufacturer name");
                },
                () -> {
                    Assertions.assertEquals(expectedModernFamilyInfo.getManfAddress(),
                            actualModernFamilyInfo.getManfAddress(),
                            "Miss match in manufacturer Address");
                },
                () -> {
                    Assertions.assertEquals(expectedModernFamilyInfo.getMaterialUsed(),
                            actualModernFamilyInfo.getMaterialUsed(),
                            "Miss match in material");

                },
                () -> {
                    Assertions.assertEquals(expectedModernFamilyInfo.getManfDate(),
                            actualModernFamilyInfo.getManfDate(),
                            "Miss match in manufactured date");

                }
        );


    }

    @ParameterizedTest
    @MethodSource("victoriaVariants")
    void resultShouldBeVictoriaFamilyInfo(String familyName) {
        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();
        FurnitureInfo actualVictoriaFamilyInfo = extractFamilyInfo.getInfo(familyName);

        Assertions.assertEquals(expectedVictoriaFamilyInfo.getClass(), actualVictoriaFamilyInfo.getClass());
        Assertions.assertAll(
                "Victoria Family Info Verification",
                () -> {
                    Assertions.assertEquals(expectedVictoriaFamilyInfo.getManfName(),
                            actualVictoriaFamilyInfo.getManfName(),
                            "Miss match in manufacturer name");
                },
                () -> {
                    Assertions.assertEquals(expectedVictoriaFamilyInfo.getManfAddress(),
                            actualVictoriaFamilyInfo.getManfAddress(),
                            "Miss match in manufacturer Address");
                },
                () -> {
                    Assertions.assertEquals(expectedVictoriaFamilyInfo.getMaterialUsed(),
                            actualVictoriaFamilyInfo.getMaterialUsed(),
                            "Miss match in material");

                },
                () -> {
                    Assertions.assertEquals(expectedVictoriaFamilyInfo.getManfDate(),
                            actualVictoriaFamilyInfo.getManfDate(),
                            "Miss match in manufactured date");

                }
        );


    }


    @ParameterizedTest
    @MethodSource("invalidValues")
    void resultShouldBeInvalidFamilyName(String familyName) {
        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    FurnitureInfo actualFamilyInfo = extractFamilyInfo.getInfo(familyName);
                });
        Assertions.assertEquals("Invalid Family Name", exception.getMessage());


    }

    @Test
    void resultShouldBeFamilyMemberDoesntExist()
    {
        String familyName= "Random Member";

        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    FurnitureInfo actualFamilyInfo = extractFamilyInfo.getInfo(familyName);
                });
        Assertions.assertEquals("Family Member doesnt exist", exception.getMessage());


    }


}
