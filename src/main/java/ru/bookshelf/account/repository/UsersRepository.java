package ru.bookshelf.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bookshelf.account.enteties.User;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * @author Raphael Kalimullin <raphaelkalimullin@gmail.com>
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(@Nonnull String login);
}
