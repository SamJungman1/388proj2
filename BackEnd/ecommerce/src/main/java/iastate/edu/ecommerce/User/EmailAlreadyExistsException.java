package iastate.edu.ecommerce.User;

public class EmailAlreadyExistsException extends Exception{
    public EmailAlreadyExistsException(String errorMessage)
    {
        super(errorMessage);
    }
    public EmailAlreadyExistsException()
    {
        super();
    }
}
