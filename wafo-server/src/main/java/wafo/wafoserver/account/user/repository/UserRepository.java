package wafo.wafoserver.account.user.repository;

import java.util.Optional;
import wafo.wafoserver.account.user.User;

public interface UserRepository {
    Long save(User user);

    Optional<User> findById(Long id);
}
