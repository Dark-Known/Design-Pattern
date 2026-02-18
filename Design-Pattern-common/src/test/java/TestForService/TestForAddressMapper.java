package TestForService;

import Service.AddressMapper;
import Utils.AddressInfo;
import Utils.JsonObj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestForAddressMapper {
    private final JsonObj jsonObj=  new JsonObj("Road", 500, "modern chair",
            "User1", "Address1",
            "SourceAddress1", "destinationAddress1");

    static Stream<Arguments> invalidAddress(){
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n"),
                Arguments.of((Object) null)
        );
    }

    @Test
    void resultShouldBeAddressInfoObj()
    {
        AddressMapper addressMapper = new AddressMapper();
        AddressInfo addressInfoObj= addressMapper.map(jsonObj);

        Assertions.assertEquals(AddressInfo.class,addressInfoObj.getClass());
    }

    @ParameterizedTest
    @MethodSource("invalidAddress")
    void resultShouldBeInvalidSourceAddress(String invalidSourceAddress)
    {
        JsonObj tempJsonObj =  new JsonObj("Road", 500, "modern chair",
                "User1", "Address1",
                invalidSourceAddress, "destinationAddress1");
        AddressMapper addressMapper = new AddressMapper();

        IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    AddressInfo addressInfoObj= addressMapper.map(tempJsonObj);
                });

        Assertions.assertEquals("Source Address is invalid",exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidAddress")
    void resultShouldBeInvalidDestAddress(String invalidDestAddress)
    {
        JsonObj tempJsonObj =  new JsonObj("Road", 500, "modern chair",
                "User1", "Address1",
                "SourceAddress1", invalidDestAddress);
        AddressMapper addressMapper = new AddressMapper();

        IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    AddressInfo addressInfoObj= addressMapper.map(tempJsonObj);
                });

        Assertions.assertEquals("Destination Address is invalid",exception.getMessage());
    }

    }

