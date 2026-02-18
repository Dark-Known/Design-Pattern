package TestForService;

import Service.CargoInfoMapper;
import Service.CargoParser;
import Service.ExtractFamilyInfo;
import Utils.CargoInfo;
import Utils.JsonObj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestForCargoInfoMapper {
    private final JsonObj jsonObj = new JsonObj("Road", 500, "modern chair",
            "User1", "Address1",
            "SourceAddress1", "destinationAddress1");
    ExtractFamilyInfo extractor = new ExtractFamilyInfo();
    CargoParser cargoParser = new CargoParser();
    CargoInfoMapper cargoInfoMapper = new CargoInfoMapper(extractor, cargoParser);

    static Stream<Arguments> invalidValues() {
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n")
        );
    }

    @Test
    void resultShouldBeCargoInfoObj() {
        CargoInfo cargoInfoObj = cargoInfoMapper.map(jsonObj);
        Assertions.assertEquals(CargoInfo.class, cargoInfoObj.getClass());
    }


    @ParameterizedTest
    @MethodSource("invalidValues")
    void resultShouldBeInvalidParameterTypes(String invalidString) {
        JsonObj tempJsonObj1 = new JsonObj(invalidString, 500, "modern chair",
                "User1", "Address1",
                "SourceAddress1", "destinationAddress1");

        JsonObj tempJsonObj2 = new JsonObj("Road", 500, invalidString,
                "User1", "Address1",
                "SourceAddress1", "destinationAddress1");
        JsonObj tempJsonObj3 = new JsonObj("Road", 0, "modern chair",
                "User1", "Address1",
                "SourceAddress1", "destinationAddress1");

        Assertions.assertAll("Invalid Parameter Types",
                () -> {
                    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                            () -> {
                                cargoInfoMapper.map(tempJsonObj1);
                            });
                    Assertions.assertEquals("Invalid Transport Type", exception.getMessage());

                },
                () -> {
                    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                            () -> {
                                cargoInfoMapper.map(tempJsonObj2);
                            });
                    Assertions.assertEquals("Invalid Cargo Name", exception.getMessage());

                },
                () -> {
                    IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                            () -> {
                                cargoInfoMapper.map(tempJsonObj3);
                            });
                    Assertions.assertEquals("Invalid Distance Information", exception.getMessage());

                }


        );

    }


}
