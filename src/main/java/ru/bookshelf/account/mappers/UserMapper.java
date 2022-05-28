package ru.bookshelf.account.mappers;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.bookshelf.account.enteties.User;
import ru.bookshelf.account.requests.UserRequest;

import javax.annotation.Nonnull;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class UserMapper {

    @Nonnull
    public static User toModel(@Nonnull UserRequest userRequest) {
        return new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail(), "ROLE_ADMIN");
    }
}
