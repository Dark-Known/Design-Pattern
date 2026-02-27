package Service;

import Utils.ErrorList;

public interface IFieldValidator {
   <T> ErrorList validateFormat(String fieldName,T fieldValue);
    <T> ErrorList validateValue(T fieldValue);
    <T> ErrorList isValid(String fieldName,T fieldValue);



}
