package wafo.wafoserver.folder.repository;

import jakarta.persistence.EntityManager;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wafo.wafoserver.folder.Folder;

@Repository
@RequiredArgsConstructor
public class JpaFolderRepository implements FolderRepository {

    private final EntityManager em;

    @Override
    public Long save(Folder folder) {
        em.persist(folder);
        return folder.getId();
    }

    @Override
    public Optional<Folder> findById(Long id) {
        Folder folder = em.find(Folder.class, id);
        return Optional.ofNullable(folder);
    }
}
