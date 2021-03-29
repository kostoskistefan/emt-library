package mk.ukim.finki.library.models.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException
{
    public UsernameAlreadyExistsException(String username)
    {
        super(String.format("Username: %s Already Exists", username));
    }
}
