package ru.bookshelf.account.util;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.bookshelf.account.enteties.User;
import ru.bookshelf.account.requests.UserRequest;
import ru.bookshelf.account.services.UserDetailsServiceImpl;

import javax.annotation.Nonnull;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@AllArgsConstructor
@Component
public class UserValidator implements Validator {

    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(@Nonnull Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(@Nonnull Object o, @Nonnull Errors errors) {
        var user = (UserRequest) o;

        try {
            userDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return; // все ок, пользователь не найден
        }

        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }
}
