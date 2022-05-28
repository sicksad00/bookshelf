package ru.bookshelf.account.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bookshelf.account.enteties.User;
import ru.bookshelf.account.repository.UsersRepository;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@AllArgsConstructor
@Service
public class RegistrationService {

    private final UsersRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //  user.setRole("ROLE_USER");

        user.setRole("ROLE_ADMIN");
        peopleRepository.save(user);
    }
}
