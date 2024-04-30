package wafo.wafoserver.folder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wafo.wafoserver.account.user.User;
import wafo.wafoserver.account.user.repository.UserRepository;
import wafo.wafoserver.folder.Folder;
import wafo.wafoserver.folder.controller.dto.FolderCreateRequest;
import wafo.wafoserver.folder.controller.dto.FolderCreateResponse;
import wafo.wafoserver.folder.dto.CreateFolderDto;
import wafo.wafoserver.folder.repository.FolderRepository;

// TODO: folderRepository save()
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FolderService {
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    @Transactional
    public FolderCreateResponse create(FolderCreateRequest folderCreateRequest) {

        User user = userRepository.findById(folderCreateRequest.getUserId()).get();

        Folder folder = Folder.create(
                new CreateFolderDto(
                        folderCreateRequest.getName(), user
                )
        );

        return new FolderCreateResponse(folder.getName(), user.getNickname());
    }
}
