package TestForService;

import Utils.ErrorList;
import Utils.ErrorType;
import Utils.ValidationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestForErrorList {


    @Test
    @DisplayName("Empty() should initialise return ErrorList obj with empty list")
    void ShouldCreateEmptyList()
    {
       ErrorList errorListObj=  ErrorList.empty();
       List<ValidationResult> errorList= errorListObj.getResultList();

        Assertions.assertTrue(errorList.isEmpty());
    }

    @Test
    @DisplayName("We Should be Label to add different types of messages")
    void ShouldBeAbleToDifferentTypeMessage()
    {
        ErrorList errorListObj= ErrorList.empty();
        errorListObj.withSuccess("Operation Success");
        errorListObj.withFailure("Operation Failed");
        errorListObj.withWarning("Operation success with warning");
        List<ValidationResult> actualErrorList=errorListObj.getResultList();

        Assertions.assertEquals(3,actualErrorList.size());

        Assertions.assertEquals("Operation Success",actualErrorList.get(0).getMessage());
        Assertions.assertEquals(ErrorType.SUCCESS,actualErrorList.get(0).getType());
        Assertions.assertEquals("Operation Failed",actualErrorList.get(1).getMessage());
        Assertions.assertEquals(ErrorType.FAILURE,actualErrorList.get(1).getType());
        Assertions.assertEquals("Operation success with warning",actualErrorList.get(2).getMessage());
        Assertions.assertEquals(ErrorType.WARNING,actualErrorList.get(2).getType());
    }

    @Test
    @DisplayName("Of() should be able to initialise ErrorList with existing List")
    void ShouldCreateWithExistingList()
    {

        List<ValidationResult> errorList= List.of(
                ValidationResult.setSuccessMessage("Operation Success")
        );

        ErrorList actualErrorListObj= ErrorList.of(errorList);

        Assertions.assertEquals(1,actualErrorListObj.getResultList().size());
        Assertions.assertEquals("Operation Success",actualErrorListObj.getResultList().
                get(0).getMessage());

    }

    @Test
    @DisplayName("Should Throw Unsupported Bug upon Adding a element to Result List")
    void ShouldThrowUnsupportedException()
    {
        List<ValidationResult> errorList= List.of(
                ValidationResult.setSuccessMessage("Operation Success")
        );

        ErrorList actualErrorListObj= ErrorList.of(errorList);
        List<ValidationResult> resultList= actualErrorListObj.getResultList();


        Assertions.assertThrows(UnsupportedOperationException.class,
                ()->{
                    resultList.add(ValidationResult.setSuccessMessage("Test"));
                });
    }

    @Test
    @DisplayName("mergeList() should be able to merge result lists")
    void ShouldBeAbleToMergeList()
    {
        ErrorList errorListObj =ErrorList.empty();
        errorListObj.withSuccess("Test");
        List<ValidationResult> tempResultList=List.of(
                ValidationResult.setSuccessMessage("Test Message")
        );
        ErrorList updatedErrorListObj=errorListObj.mergeList(tempResultList);

        Assertions.assertEquals(2,updatedErrorListObj.getResultList().size());

    }
}
