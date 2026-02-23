package Service;

import Utils.JsonObj;


//TODO: we should move basic validation for fields in json to here ,
// So that this can act as centralised validator ,
// which eliminates duplicate validation code in entire codebase

public class ValidateJson {

    public void validate(JsonObj jsonobj)
    {
        if(jsonobj==null)
        {
            throw new IllegalArgumentException("Invalid Json Object");
        }
    }
}
