package Utils;

public class ValidationResult {
    private final String resultMessage;
    private final ErrorType errorType;

    public ValidationResult(ErrorType errorType,String resultMessage) {
        this.resultMessage = resultMessage;
        this.errorType = errorType;
    }


    public ValidationResult setSuccessMessage(String message)
    {
        return new ValidationResult(ErrorType.SUCCESS , message);
    }

    public ValidationResult setFailureMessage(String message)
    {
        return new ValidationResult(ErrorType.FAILURE,message);
    }

    public ValidationResult setWarningMessage(String message)
    {
        return new ValidationResult(ErrorType.WARNING, message);
    }

    public String getMessage()
    {
        return this.resultMessage;
    }
//    public ErrorType getType()
//    {
//        return this.errorType;
//    }
    public boolean isFailure()
    {
        return this.errorType==ErrorType.FAILURE;
    }
    public boolean isSuccess()
    {
        return this.errorType==ErrorType.SUCCESS;
    }
}

