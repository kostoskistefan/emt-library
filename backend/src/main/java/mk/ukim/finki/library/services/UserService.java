package mk.ukim.finki.library.services;

import mk.ukim.finki.library.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
    User register(String username, String password, String name, String surname);
}
