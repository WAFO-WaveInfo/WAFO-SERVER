package wafo.wafoserver;

import jakarta.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.Folder;
import wafo.wafoserver.folder.repository.FolderRepository;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final UserRepository userRepository;
        private final FolderRepository folderRepository;

        public void dbInit1() {
            Long userId1 = userRepository.save(new User("test1@wafo.io", "user1", "testUser1"));
            Long userId2 = userRepository.save(new User("test2@wafo.io", "user2", "testUser2"));
            Long userId3 = userRepository.save(new User("test3@wafo.io", "user3", "testUser3"));

            Long folderId = folderRepository.save(new Folder("defaultFolder", userRepository.findById(userId1).get()));
        }
    }
}

