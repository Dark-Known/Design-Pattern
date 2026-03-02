package Service;

import Utils.ErrorList;

public class TextFieldValidator implements IFieldValidator{


    private static final TextFieldValidator VALIDATOR_INSTANCE =new TextFieldValidator();

    public static TextFieldValidator getInstance()
    {
        return TextFieldValidator.VALIDATOR_INSTANCE;
    }

    @Override
    public <T> ErrorList validateFormat(String fieldName, T fieldValue) {
        //TODO: To implement Logic to validate format for field
      return null;
    }

    @Override
    public <T> ErrorList validateValue(String fieldName, T fieldValue) {
        ErrorList errorList=getNewList();
        if(fieldValue==null)
        {
            errorList.withFailure(fieldName+": Value Cannot be Null");
        }
        else if(fieldValue.toString().trim().isEmpty())
        {
            errorList.withFailure(fieldName+": Invalid Value");
        }
        return errorList;
    }

    @Override
    public <T> ErrorList isValid(String fieldName, T fieldValue) {
       ErrorList errorListForValue=validateValue(fieldName, fieldValue);

       // Ternary Operator to counter null from validateFormat
       ErrorList errorListForFormat=validateFormat(fieldName,fieldValue)==null?
               ErrorList.empty(): validateFormat(fieldName,fieldValue);

       return errorListForFormat.mergeList(errorListForValue.getResultList());
    }


    private ErrorList getNewList()
    {
        return ErrorList.empty();
    }


}
