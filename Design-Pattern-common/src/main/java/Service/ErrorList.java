package Service;

import Utils.ValidationResult;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {
    private List<ValidationResult> resultList;

    private ErrorList(List<ValidationResult> resultList)
    {
        this.resultList=resultList;
    }

    public static ErrorList of(List<ValidationResult> resultEntries)
    {
        return new ErrorList(resultEntries);
    }





}
