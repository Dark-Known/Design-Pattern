package Service;

import Utils.ErrorList;

public class TextFieldValidator implements IFieldValidator{

    @Override
    public ErrorList validateFormat(String fieldName, String fieldValue) {

    }

    @Override
    public <T> ErrorList validateValue(T fieldValue) {
        return null;
    }

    @Override
    public <T> ErrorList isValid(String fieldName, T fieldValue) {
        return null;
    }
}
