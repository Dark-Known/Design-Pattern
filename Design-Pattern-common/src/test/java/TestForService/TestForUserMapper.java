package TestForService;

import Service.UserMapper;
import Utils.JsonObj;
import Utils.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestForUserMapper {

    private final JsonObj jsonObj=  new JsonObj("Road", 500, "modern chair",
            "User1", "Address1",
            "SourceAddress1", "destinationAddress1");

    static Stream<Arguments> invalidValues(){
        return Stream.of(
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("\t"),
                Arguments.of("\n"),
                Arguments.of((Object) null)
        );
    }

    @Test
    void resultBeValidUserInfoObj()
    {
        UserMapper userMapper = new UserMapper();
        UserInfo userInfo = userMapper.map(jsonObj);


        Assertions.assertEquals(UserInfo.class,userInfo.getClass());


    }


    @ParameterizedTest
    @MethodSource("invalidValues")
    void resultShouldBeInvalidUserName(String invalidUserName)
    {
        JsonObj tempJsonObj=  new JsonObj("Road", 500, "modern chair",
                invalidUserName, "Address1",
                "SourceAddress1", "destinationAddress1");

        UserMapper userMapper = new UserMapper();

        IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    UserInfo userInfo = userMapper.map(tempJsonObj);

                });

        Assertions.assertEquals("Invalid User Name",exception.getMessage());

    }
    @ParameterizedTest
    @MethodSource("invalidValues")
    void resultShouldBeInvalidUserAddress(String invalidUserAddress)
    {
        JsonObj tempJsonObj=  new JsonObj("Road", 500, "modern chair",
                "username1", invalidUserAddress,
                "SourceAddress1", "destinationAddress1");

        UserMapper userMapper = new UserMapper();

        IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    UserInfo userInfo = userMapper.map(tempJsonObj);

                });

        Assertions.assertEquals("Invalid User Address",exception.getMessage());

    }
}


