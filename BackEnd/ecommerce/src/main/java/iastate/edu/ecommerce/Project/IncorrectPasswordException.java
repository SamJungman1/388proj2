package iastate.edu.ecommerce.Project;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String errorMessage)
    {
        super(errorMessage);
    }
    public IncorrectPasswordException()
    {
        super();
    }
}
