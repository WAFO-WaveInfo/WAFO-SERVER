package wafo.wafoserver.link.repository;

import java.util.List;
import java.util.Optional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.link.Link;

public interface LinkRepository {
    Long save(Link link);

    Optional<Link> findById(Long id);

    List<Link> findAll();

    List<Link> findAllByMember(Long userId);
}
