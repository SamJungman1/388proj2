package iastate.edu.ecommerce.Project;

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
