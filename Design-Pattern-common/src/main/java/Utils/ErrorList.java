package Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ErrorList {
    private List<ValidationResult> resultList;

    private ErrorList(List<ValidationResult> resultList)
    {
        this.resultList= resultList;
    }


    // Static Factory Methods For Better Control Over Object Creation
    public static ErrorList of(List<ValidationResult> resultEntries)
    {
        return new ErrorList(resultEntries);
    }


    public static ErrorList empty()
    {
        return new ErrorList(new ArrayList<>());
    }


    //Fluent API for better usage

    public ErrorList withFailure(String message)
    {
        resultList.add(ValidationResult.setFailureMessage(message));
        return this;
    }

    public ErrorList withSuccess(String message)
    {
        resultList.add(ValidationResult.setSuccessMessage(message));
        return this;
    }

    public ErrorList withWarning(String message)
    {
        resultList.add(ValidationResult.setWarningMessage(message));
        return this;
    }

    public ErrorList mergeList(List<ValidationResult> errorList)
    {
        List<ValidationResult> updatedResultList= new ArrayList<>(resultList);
        updatedResultList.addAll(errorList);
        return ErrorList.of(updatedResultList);
    }


    public List<ValidationResult> getResultList()
    {
        return Collections.unmodifiableList(resultList);
    }






}
