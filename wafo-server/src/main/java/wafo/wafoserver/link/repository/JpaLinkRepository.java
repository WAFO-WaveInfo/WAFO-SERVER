package wafo.wafoserver.link.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.link.Link;
import wafo.wafoserver.link.LinkStatus;

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

    @Override
    public List<Link> findAll() {
        return em.createQuery("select l from Link l where" +
                        " l.linkStatus != :linkStatusHide", Link.class)
                .setParameter("linkStatusHide", LinkStatus.HIDE)
                .getResultList();
    }

    @Override
    public List<Link> findAllByMember(Long userId) {
        return em.createQuery("select l from Link l where" +
                        " l.linkStatus != :linkStatusHide and l.user.id = :userId", Link.class)
                .setParameter("linkStatusHide", LinkStatus.HIDE)
                .setParameter("userId", userId)
                .getResultList();
    }
}
