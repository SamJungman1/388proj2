package iastate.edu.ecommerce.User;

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
