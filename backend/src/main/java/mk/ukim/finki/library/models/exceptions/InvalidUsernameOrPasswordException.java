package mk.ukim.finki.library.models.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException
{
    public InvalidUsernameOrPasswordException()
    {
        super("Invalid Username Or Password");
    }
}
