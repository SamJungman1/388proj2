package iastate.edu.ecommerce.User;

public class EmailDoesNotExistException extends Exception {
    public EmailDoesNotExistException(String errorMessage)
    {
        super(errorMessage);
    }
    public EmailDoesNotExistException()
    {
        super();
    }
}
