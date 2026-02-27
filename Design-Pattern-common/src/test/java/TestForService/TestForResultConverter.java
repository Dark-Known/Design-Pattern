package TestForService;

import Service.ResultConverter;
import Utils.ErrorList;
import Utils.ErrorType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestForResultConverter {

    ErrorList errorList;
    ResultConverter resultConverter;

    @BeforeEach
    void setUp()
    {
        errorList= ErrorList.empty();
        errorList.withSuccess("Transaction Success for OP1");
        errorList.withSuccess("Transaction Success for OP2");
        errorList.withFailure("Transaction Failure for OP1");
        errorList.withFailure("Transaction Failure for OP2");
        errorList.withWarning("Transaction Successful with Warning for OP1");
        errorList.withWarning("Transaction Successful with Warning for OP2");
        resultConverter= new ResultConverter();
    }


    @Test
    @DisplayName("Should return list of Messages based on error type")
    void ShouldExtractMessageBasedOnType()
    {
        List<String> actualFailureList=  resultConverter.extractByType(errorList, ErrorType.FAILURE);
        List<String> expectedFailureList= List.of(
                "Transaction Failure for OP1",
                "Transaction Failure for OP2"
        );

        Assertions.assertEquals(2,actualFailureList.size());
        Assertions.assertEquals(expectedFailureList.get(0),actualFailureList.get(0));
        Assertions.assertEquals(expectedFailureList.get(1),actualFailureList.get(1));

    }
    @Test
    @DisplayName("Should return list of loggable Messages")
    void ShouldExtractLoggableMessage()
    {
        List<String> logMessageList= resultConverter.getLoggableMessage(errorList);
        Assertions.assertEquals(6,logMessageList.size());
        Assertions.assertEquals("[SUCCESS] Transaction Success for OP1",logMessageList.get(0));
    }

    @Test
    @DisplayName("Should return failure messages")
    void ShouldExtractFailureMessage()
    {
        List<String> failureMessageList= resultConverter.getFailureMessageList(errorList);
        Assertions.assertEquals(2,failureMessageList.size());
        Assertions.assertEquals("Transaction Failure for OP1",failureMessageList.get(0));
    }

    @Test
    @DisplayName("List extracted Should not be modifiable")
    void ShouldThrowUnsupportedException()
    {
        List<String> actualFailureList=  resultConverter.getLoggableMessageByType(errorList, ErrorType.FAILURE);

        Assertions.assertThrows(UnsupportedOperationException.class,
                ()->{
                    actualFailureList.add("Test");
                });

    }
}
