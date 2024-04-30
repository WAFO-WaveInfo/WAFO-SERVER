package wafo.wafoserver.link.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.Folder;
import wafo.wafoserver.folder.repository.FolderRepository;
import wafo.wafoserver.link.controller.dto.LinkCreateRequest;
import wafo.wafoserver.link.controller.dto.LinkCreateResponse;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class LinkServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    private LinkService linkService;

    @Test
    public void 링크_생성() throws Exception {
        // given
        User user = userRepository.findById(1L).get();
        Folder folder = folderRepository.findById(1L).get();

        // when
        LinkCreateResponse linkCreateResponse = linkService.create(
                new LinkCreateRequest(user.getId(), "www.wafo.io", "test", "faviconUrl", folder.getId()));

        // then
        assertEquals("defaultFolder", linkCreateResponse.getFolder().getName());
        assertEquals("www.wafo.io", linkCreateResponse.getUrl());
        assertEquals("test", linkCreateResponse.getTitle());
    }

}