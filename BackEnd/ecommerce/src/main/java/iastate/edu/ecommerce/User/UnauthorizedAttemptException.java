package iastate.edu.ecommerce.User;

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
