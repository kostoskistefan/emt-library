package mk.ukim.finki.library.services.impl;

import mk.ukim.finki.library.models.User;
import mk.ukim.finki.library.models.enumerations.Role;
import mk.ukim.finki.library.models.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.library.models.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.library.repositories.UserRepository;
import mk.ukim.finki.library.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }

    @Override
    public User register(String username, String password, String name, String surname)
    {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();

        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(username, this.passwordEncoder.encode(password), name, surname, Role.ROLE_USER);

        return this.userRepository.save(user);
    }}
