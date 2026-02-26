package Service;

import Utils.ErrorList;
import Utils.ErrorType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultConverter {

    public List<String> getFailureMessageList(ErrorList errorList)
    {
        return extractMessage(errorList,ErrorType.FAILURE);
    }


    public List<String> extractByType(ErrorList errorList, ErrorType resultType)
    {
       return extractMessage(errorList,resultType);

    }

    public List<String> getLoggableMessage(ErrorList errorList)
    {
       return extractLoggableMessage(errorList,null);

    }
    public List<String> getLoggableMessageByType(ErrorList errorList, ErrorType resultType)
    {
        return extractLoggableMessage(errorList,resultType);

    }


    private List<String> extractMessage(ErrorList errorList, ErrorType errorType)
    {
        List<String> MessageList = new ArrayList<>();
        errorList.getResultList().forEach(
                (validationResult)->{
                    if(validationResult.getType()==errorType || errorType==null)
                    {
                        MessageList.add(validationResult.getMessage());
                    }
                }
        );
        return Collections.unmodifiableList(MessageList);
    }
    private List<String> extractLoggableMessage(ErrorList errorList, ErrorType errorType)
    {
        List<String> MessageList = new ArrayList<>();
        errorList.getResultList().forEach(
                (validationResult)->{
                    if(validationResult.getType()==errorType || errorType==null)
                    {
                        MessageList.add(validationResult.toString());
                    }
                }
        );
        return Collections.unmodifiableList(MessageList);
    }
}

