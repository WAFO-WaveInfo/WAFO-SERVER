package wafo.wafoserver.link.repository;

import java.util.Optional;
import wafo.wafoserver.link.Link;

public interface LinkRepository {
    Long save(Link link);

    Optional<Link> findById(Long id);
}
