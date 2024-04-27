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

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FolderService {
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    @Transactional
    public FolderCreateResponse create(FolderCreateRequest folderCreateRequest) {

        // Dummy User
        Long userId = userRepository.save(new User("test@wafo.io", "gildong", "gildongNickname"));

        // User user = userRepository.findById(folderCreateRequest.getUserId()).get();

        // Use Dummy User
        User user = userRepository.findById(userId).get();

        Folder folder = Folder.create(
                new CreateFolderDto(
                        folderCreateRequest.getName(), user
                )
        );

        return new FolderCreateResponse(folder.getName(),user.getNickname());
    }
}
