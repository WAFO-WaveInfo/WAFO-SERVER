package wafo.wafoserver.link.repository;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wafo.wafoserver.link.Link;

@Repository
@RequiredArgsConstructor
public class JpaLinkRepository implements LinkRepository {

    private final EntityManager em;


    @Override
    public Long save(Link link) {
        em.persist(link);
        return link.getId();
    }

    @Override
    public Optional<Link> findById(Long id) {
        Link link = em.find(Link.class, id);
        return Optional.ofNullable(link);
    }
}
