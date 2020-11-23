package iastate.edu.ecommerce.Project;

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
