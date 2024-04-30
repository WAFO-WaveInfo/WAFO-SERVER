package wafo.wafoserver.link.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.Folder;
import wafo.wafoserver.folder.repository.FolderRepository;
import wafo.wafoserver.link.Link;
import wafo.wafoserver.link.controller.dto.LinkCreateRequest;
import wafo.wafoserver.link.controller.dto.LinkCreateResponse;
import wafo.wafoserver.link.dto.CreateLinkDto;
import wafo.wafoserver.link.repository.LinkRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LinkService {
    private static final Long DEFAULT_FOLDER_ID = 1L;

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;

    @Transactional
    public LinkCreateResponse create(LinkCreateRequest linkCreateRequest) {

        User user = userRepository.findById(linkCreateRequest.getUserId()).get();
        Folder folder = folderRepository.findById(DEFAULT_FOLDER_ID).get();

        Link link = Link.create(
                new CreateLinkDto(
                        user,
                        folder,
                        linkCreateRequest.getUrl(),
                        linkCreateRequest.getTitle(),
                        linkCreateRequest.getFaviconUrl()
                )
        );

        linkRepository.save(link);

        return new LinkCreateResponse(
                link.getUrl(),
                link.getTitle(),
                link.getFavicon_url(),
                link.getFolder().getId()
        );
    }
}
