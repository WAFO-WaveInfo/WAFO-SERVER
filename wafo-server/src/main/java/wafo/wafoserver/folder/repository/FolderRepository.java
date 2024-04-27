package wafo.wafoserver.folder.repository;

import java.util.Optional;
import wafo.wafoserver.folder.Folder;

public interface FolderRepository {
    Long save(Folder folder);

    Optional<Folder> findById(Long id);
}
