package iastate.edu.ecommerce.Project;

public class UnauthorizedAttemptException extends Exception {
    public UnauthorizedAttemptException(String errorMessage)
    {
        super(errorMessage);
    }
    public UnauthorizedAttemptException()
    {
        super();
    }
}
