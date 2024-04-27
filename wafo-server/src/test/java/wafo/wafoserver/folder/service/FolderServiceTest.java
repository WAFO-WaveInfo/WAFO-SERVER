package wafo.wafoserver.folder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.controller.dto.FolderCreateRequest;
import wafo.wafoserver.folder.controller.dto.FolderCreateResponse;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class FolderServiceTest {

    @Autowired
    FolderService folderService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 폴더생성() throws Exception {
        //given
        User user = userRepository.findById(1L).get();
        //when
        FolderCreateResponse folderCreateResponse = folderService.create(
                new FolderCreateRequest(user.getName(), user.getId()));
        //then
        assertEquals("testUser1", folderCreateResponse.getUserName());
    }
}